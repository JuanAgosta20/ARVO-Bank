package com.Controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.ClientDaoImpl;
import com.Dao.LogInDaoImpl;
import com.Model.Administrative;
import com.Model.Client;
import com.Model.User;


@SessionAttributes("user")
public class LogInController {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("com/Resources/Beans.xml");

	@RequestMapping("login.do")
	public ModelAndView redirectTransfers(String txtUsername, String txtPass) {
		ModelAndView MV = new ModelAndView();
		User user = (User) appContext.getBean("User");
		LogInDaoImpl login = (LogInDaoImpl) appContext.getBean("LogInDaoImpl") ;
		
		user = login.loginUser(txtUsername, txtPass);
		
		if(user.getUserType() == "Admin") {
			//Administrative adm = (AdmintDaoImpl) appContext.getBean("AdminDaoImpl");
			//MV.addObject("user", adm);
			MV.setViewName("admClients");
		}else {
			ClientDaoImpl cdao =  (ClientDaoImpl) appContext.getBean("ClientDaoImpl");
			Client client = cdao.getClient(user.getIdUser());
			MV.addObject("user", client);
			MV.addObject("accounts", client.getBankAccounts());
			MV.setViewName("accounts");
		}
		return MV;
	}
}
