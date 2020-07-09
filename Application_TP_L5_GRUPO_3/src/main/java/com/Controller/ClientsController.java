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
import com.Model.Loan;
import com.Model.Transaction;
import com.Model.typeMove;
import com.Services.AccountService;
import com.Services.AccountServiceImpl;
import com.Services.LoanService;
import com.Services.LoanServiceImpl;
import com.Services.TransactionService;
import com.Services.TransactionServiceImpl;
import com.Services.UserService;

@Controller
public class ClientsController {
	
	BeanFactory bf = new BeanFactory();
	UserService us = bf.createUserServiceImpl();
	AccountService as = new AccountServiceImpl();
	LoanService ls = new LoanServiceImpl();
	TransactionService ts = new TransactionServiceImpl();
	
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
	public ModelAndView Transfers(HttpServletRequest req){
		ModelAndView mv = new ModelAndView("transfers");
		HttpSession session = req.getSession();
		Client client = (Client)session.getAttribute("user");
	    mv.addObject("accounts", as.getAccountsFrom(client.getIdClient()));
		return mv;
	}
	
	
	
	
	@RequestMapping("clLoans")
	public ModelAndView Loans(HttpServletRequest req){
		ModelAndView mv = new ModelAndView("loans");
		HttpSession session = req.getSession();
		Client client = (Client)session.getAttribute("user");
		mv.addObject("loans", ls.getLoansFrom(client.getIdClient()));
		mv.addObject("accounts", as.getAccountsFrom(client.getIdClient()));
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
	
	@RequestMapping(value="clRequestLoan", method=RequestMethod.POST)
	public ModelAndView RequestNewLoan(String txtAmmount, int cmbCuotas, int cmbAccount , HttpServletRequest req) {
		HttpSession session = req.getSession();
		Client client = (Client)session.getAttribute("user");
		Loan loan = new Loan();
		loan.setState(1);
		loan.setClient(client);
		float ammount = Float.parseFloat(txtAmmount);
		loan.setAmmount(ammount);
		loan.setFees(cmbCuotas);
		loan.setMonthAmmount((float)ammount/cmbCuotas);
		loan.setIdAccount(cmbAccount);
		loan.setDate(Cmd.crearFecha());
		Boolean result = ls.insertLoan(loan);
		ModelAndView mv = new ModelAndView("accounts");
		mv.addObject("result", result); //true bien, false mal
		mv.addObject("msg", new String[]{"Opps... a ocurrido un error", "La petición se ha enviado correctamente"});
		return Accounts(mv, req);
	}
	
	@RequestMapping(value="clRequesTransfer", method=RequestMethod.POST)
	public ModelAndView RequestNewTransfer(String cmbAccountFrom, String cmbAccountTo,String txtAmmount,String txtConcept, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("transfers");
		HttpSession session = req.getSession();
		Client client = (Client)session.getAttribute("user");
	
		//realizada
		Transaction t1 = new Transaction();
		//recibida
		Transaction t2 = new Transaction();
		t1.setState((byte) 1);
		t2.setState((byte) 1);
		float ammount = Float.parseFloat(txtAmmount);
		t1.setAmmount(ammount);
		t2.setAmmount(ammount);
		t1.setDate(Cmd.crearFecha());
		t2.setDate(Cmd.crearFecha());
		t1.setConcept(txtConcept);
		t2.setConcept(txtConcept);
		Account accFrom = as.getAccount(cmbAccountFrom);
		Account accTo = as.getAccount(cmbAccountTo);
		t1.setOriginAccount(accFrom);
		t1.setDestinationAccount(accTo);
		t2.setOriginAccount(accFrom);
		t2.setDestinationAccount(accTo);
		float Saldo = Float.parseFloat(txtAmmount);
		t1.setTm(ts.getType(3));
		t2.setTm(ts.getType(4));
		float nuevoSaldo = accFrom.getFunds() - Saldo;
		t1.setHistory(nuevoSaldo);
		as.updateFunds(accFrom.getIdAccount(), nuevoSaldo);	
		nuevoSaldo = accTo.getFunds() + Saldo;
		t2.setHistory(nuevoSaldo);
		as.updateFunds(accTo.getIdAccount(), nuevoSaldo);
		ts.insertTransaction(t1);
		ts.insertTransaction(t2);
		
		return mv;
	}
	
	

}
