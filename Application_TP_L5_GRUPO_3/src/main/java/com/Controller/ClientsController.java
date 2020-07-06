package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.SessionHandler;
import com.Model.Account;
import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.Cmd;
import com.Services.AccountService;
import com.Services.AccountServiceImpl;
import com.Services.LoanService;
import com.Services.LoanServiceImpl;
import com.Services.UserService;

@Controller
public class ClientsController {
	
	BeanFactory bf = new BeanFactory();
	UserService us = bf.createUserServiceImpl();
	AccountService as = new AccountServiceImpl();
	LoanService ls = new LoanServiceImpl();
	
	@RequestMapping("clAccounts")
	public ModelAndView Accounts(ModelAndView mv, HttpServletRequest req){
		if(mv.isEmpty())
		 mv = new ModelAndView("accounts");
		HttpSession session = req.getSession();
		Client cl = (Client)session.getAttribute("user");
		mv.addObject("acccountTypes", as.getAllTypes());
		mv.addObject("idClient", cl.getIdClient());
		mv.addObject("accounts", as.getAccountsFrom(cl.getIdClient()));
		return mv; 
	}
	
	@RequestMapping("clTransfers")
	public ModelAndView Transfers(){
		return new ModelAndView("transfers");
	}
	
	@RequestMapping("clLoans")
	public ModelAndView Loans(HttpServletRequest req){
		ModelAndView mv = new ModelAndView("loans");
		HttpSession session = req.getSession();
		Client client = (Client)session.getAttribute("user");
		mv.addObject("loans", ls.getLoansFrom(client.getIdClient()));
		return mv;
	}
	
	@RequestMapping(value="clRequestAccount", method=RequestMethod.POST)
	public ModelAndView RequestNewAccount(int cmbAccounts, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Client client = (Client)session.getAttribute("user");
		Account acc = new Account();
		acc.setState(1);
		acc.setClient(client);
		acc.setTypeAcc(as.getType(cmbAccounts));
		acc.setCreationDate(Cmd.crearFecha());
		Boolean result = as.insertAccount(acc);
		ModelAndView mv = new ModelAndView("accounts");
		mv.addObject("result", result); //true bien, false mal
		mv.addObject("msg", new String[]{"Opps... a ocurrido un error", "La petición se ha enviado correctamente"});
		return Accounts(mv, req);
	}

}
