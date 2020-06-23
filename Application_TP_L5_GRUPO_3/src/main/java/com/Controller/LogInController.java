package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Model.Client;
import com.Model.User;
import com.Services.UserService;

@SessionAttributes("user")
public class LogInController {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("com/Resources/Beans.xml");
	UserService us = (UserService) appContext.getBean("UserSericeImpl");

	@RequestMapping("login.do")
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
