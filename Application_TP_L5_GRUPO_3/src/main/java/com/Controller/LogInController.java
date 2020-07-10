package com.Controller;

import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Model.Administrative;
import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.User;
import com.Services.ClientService;
import com.Services.LocationService;
import com.Services.UserService;

@Controller
// @SessionAttributes("user")
public class LogInController {

	UserService us = BeanFactory.createUserServiceImpl();
	ClientService sClient = BeanFactory.createClientServiceImpl();
	LocationService sLocation = BeanFactory.createLocationServiceImpl();

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView redirectLogIn(String txtUsername, String txtPass, HttpServletRequest req) {
		ModelAndView MV = new ModelAndView();
		User user = us.getUser(txtUsername, txtPass);

		HttpSession session = req.getSession();

		if (user == null) {
			MV.addObject("NoUser", "El usuario solicitado no existe");
			MV.setViewName("index");
			return MV;
		} else if (user.getUserType().equals("Admin")) {
			Administrative adm = us.getAdmin(user);
			
			MV.addObject("clients", sClient.readClients());
			MV.addObject("countries", sLocation.getAllCountries());
			MV.addObject("province", sLocation.getAllProvince());
			
			session.setAttribute("user", adm);
			MV.setViewName("admClients");
		} else if (user.getUserType().equals("Cliente")) {
			Client client = sClient.readClientByUserId(user);
			session.setAttribute("user", client);
			if(client.getDni().equals(client.getUser().getPassword())) {
				MV.setViewName("NewPass");
			}else {
				MV.setViewName("redirect:clAccounts.do");
			}
		}

		return MV;
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	public ModelAndView redirectLogOut(HttpServletRequest req) {
		ModelAndView MV = new ModelAndView();
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping(value = "clNewPass.do", method = RequestMethod.POST)
	public ModelAndView redirectNewPass(String pass, int id) {
		ModelAndView MV = new ModelAndView();
		us.updatePassword(pass,id);
		MV.setViewName("redirect:clAccounts.do");
		return MV;
	}
}
