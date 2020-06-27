package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Model.Account;
import com.Model.BeanFactory;
import com.Model.Cmd;
import com.Services.AccountService;
import com.Services.UserService;

@Controller
public class ClientsController {
	
	BeanFactory bf = new BeanFactory();
	UserService us = bf.createUserServiceImpl();
	AccountService as = bf.getAccountServiceImpl();
	
	@RequestMapping("clAccounts")
	public ModelAndView Accounts(){
		ModelAndView mv = new ModelAndView("accounts");
		mv.addObject("acccountTypes", as.getAllTypes());
		mv.addObject("idClient", 1);
		return mv; 
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
	public ModelAndView RequestNewAccount(int idClient, int cmbAccounts) {
		Account acc = new Account();
		acc.setState((byte)1);
		//as.insertAccount(acc);
		return new ModelAndView("accounts");
	}
}
