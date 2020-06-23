package com.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.User;
import com.Services.UserService;

@Controller
@SessionAttributes("user")
public class LogInController {
	
	BeanFactory bf = new BeanFactory();
	UserService us = bf.createUserServiceImpl();

	@RequestMapping(value ="login.do", method = RequestMethod.POST)
	public ModelAndView redirectTransfers(String txtUsername, String txtPass) {
		ModelAndView MV = new ModelAndView();
		
		User user = us.getUser(txtUsername, txtPass);

		if (user.getUserType() == "Admin") {
			// Administrative adm = (AdmintDaoImpl) appContext.getBean("AdminDaoImpl");
			// MV.addObject("user", adm);
			MV.setViewName("admClients");
		} else {
			
			Client client = us.getClient(user);
			MV.addObject("user", client);
			MV.addObject("accounts", client.getBankAccounts());
			MV.setViewName("accounts");
		}
		return MV;
	}
}
