package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Model.BeanFactory;
import com.Services.UserService;

@Controller
public class ClientsController {
	
	BeanFactory bf = new BeanFactory();
	UserService us = bf.createUserServiceImpl();
	
	@RequestMapping("clAccounts")
	public ModelAndView Accounts(){
		return new ModelAndView("accounts");
	}
	
	@RequestMapping("clTransfers")
	public ModelAndView Transfers(){
		return new ModelAndView("transfers");
	}
	
	@RequestMapping("clLoans")
	public ModelAndView Loans(){
		return new ModelAndView("loans");
	}
	
	@RequestMapping("clRequestAccount")
	public ModelAndView RequestNewAccount() {
		
		return new ModelAndView("accounts");
	}
}
