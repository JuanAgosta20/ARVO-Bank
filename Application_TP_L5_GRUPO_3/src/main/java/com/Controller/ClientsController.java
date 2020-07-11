package com.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Model.Account;
import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.Cmd;
import com.Model.Loan;
import com.Model.Transaction;
import com.Services.AccountService;
import com.Services.LoanService;
import com.Services.TransactionService;
import com.Services.UserService;
import com.google.gson.Gson;

@Controller
public class ClientsController {
	
	UserService us = BeanFactory.createUserServiceImpl();
	AccountService as = BeanFactory.createAccountServiceImpl();
	LoanService ls = BeanFactory.createLoanServiceImpl();
	TransactionService ts = BeanFactory.createTransactionServiceImpl();
	
	@RequestMapping("clAccounts")
	public ModelAndView Accounts(ModelAndView mv, HttpServletRequest req) {
		if (mv.isEmpty())
			mv = new ModelAndView("accounts");
		HttpSession session = req.getSession();
		Client cl = (Client) session.getAttribute("user");
		mv.addObject("acccountTypes", as.getAllTypes());
		mv.addObject("idClient", cl.getIdClient());
		mv.addObject("accounts", as.getAccountsFrom(cl.getIdClient()));
		return mv;
	}

	@RequestMapping("clTransfers")
	public ModelAndView Transfers(ModelAndView mv, HttpServletRequest req) {
		if (mv.isEmpty())
			mv = new ModelAndView("transfers");
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("user");
		mv.addObject("accounts", as.getAccountsFrom(client.getIdClient()));
		return mv;
	}
	
	@RequestMapping("clTransactions")
	public ModelAndView Transactions(ModelAndView mv, String CBU) {
		if (mv.isEmpty())
			mv = new ModelAndView("transactions");
		
		Account account = as.getAccount(CBU);
		mv.addObject("account",account);
		Integer id = account.getIdAccount();
		mv.addObject("transactions",ts.getAllTransactions(id));
		mv.addObject("typemoves", ts.getAllTypes());
		return mv;
		
	}

	@RequestMapping("clLoans")
	public ModelAndView Loans(ModelAndView mv, HttpServletRequest req) {
		if (mv.isEmpty())
			mv = new ModelAndView("loans");
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("user");
		mv.addObject("loans", ls.getLoansFrom(client.getIdClient()));
		mv.addObject("accounts", as.getAccountsFrom(client.getIdClient()));
		return mv;
	}

	@RequestMapping(value = "clRequestAccount", method = RequestMethod.POST)
	public ModelAndView RequestNewAccount(int cmbAccounts, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("user");
		Account acc = BeanFactory.createAccount();
		acc.setState(1);
		acc.setClient(client);
		acc.setTypeAcc(as.getType(cmbAccounts));
		acc.setCreationDate(Cmd.crearFecha());
		Boolean result = as.insertAccount(acc);
		ModelAndView mv = new ModelAndView("accounts");
		mv.addObject("result", result); // true bien, false mal
		mv.addObject("msg", new String[] { "Opps... ha ocurrido un error", "La peticion se ha enviado correctamente" });
		return Accounts(mv, req);
	}

	@RequestMapping(value = "clRequestLoan", method = RequestMethod.POST)
	public ModelAndView RequestNewLoan(String txtAmmount, int cmbCuotas, String cmbAccount, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("user");
		Loan loan = BeanFactory.createLoan();
		loan.setState(1);
		loan.setClient(client);
		float ammount = Float.parseFloat(txtAmmount);
		loan.setAmmount(ammount);
		loan.setFees(cmbCuotas);
		loan.setMonthAmmount((float) ammount / cmbCuotas);
		loan.setCbu(cmbAccount);
		loan.setDate(Cmd.crearFecha());
		Boolean result = ls.insertLoan(loan);
		ModelAndView mv = new ModelAndView("accounts");
		mv.addObject("result", result); // true bien, false mal
		mv.addObject("msg",
				new String[] { "Opps... ha ocurrido un error", "La peticion se ha enviado correctamente" });
		return Accounts(mv, req);
	}

	@RequestMapping(value = "clRequesTransfer", method = RequestMethod.POST)
	public ModelAndView RequestNewTransfer(String cmbAccountFrom, String cmbAccountTo, String txtAmmount,
			String txtConcept, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("transfers");

		if (!as.checkCompatibility(cmbAccountFrom, cmbAccountTo)) {

			mv.addObject("result", false);
			mv.addObject("msg", new String[] { "Debe transferir a una cuenta con la misma moneda" });
			return Transfers(mv, req);

		}
			
		Account accFrom = as.getAccount(cmbAccountFrom);
		Account accTo = as.getAccount(cmbAccountTo);
		
		if (accTo == null || accTo.getState()!=2) {
			mv.addObject("result", false);
			mv.addObject("msg", new String[]{"La cuenta destino no existe o esta inactiva"});
			return Transfers(mv, req);
		}
		
			if (accFrom.getFunds() <= Float.parseFloat(txtAmmount)) {


			mv.addObject("result", false);
			mv.addObject("msg", new String[] { "Fondos insuficientes" });
			return Transfers(mv, req);
		}

		// realizada
		Transaction t1 = BeanFactory.createTransaction();
		// recibida
		Transaction t2 = BeanFactory.createTransaction();

		t1.setState((byte) 1);
		t2.setState((byte) 1);
		float ammount = Float.parseFloat(txtAmmount);
		t1.setAmmount(ammount);
		t2.setAmmount(ammount);
		t1.setDate(Cmd.crearFecha());
		t2.setDate(Cmd.crearFecha());
		t1.setConcept(txtConcept);
		t2.setConcept(txtConcept);

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
		Boolean result;
		if (ts.insertTransaction(t1) && ts.insertTransaction(t2)) {
			result = true;

		} else {
			result = false;
		}

		mv.addObject("result", result);
		mv.addObject("msg", new String[] { "Ha ocurrido un error", "Transaccion realizada con exito" });
		return Transfers(mv, req);
	}

		
	@RequestMapping(value="clRequesTransfer3", method=RequestMethod.POST)
	public ModelAndView RequestNewTransfer3(String cmbAccountFrom1, String txtAccountTo,String txtAmmount1,String txtConcept1, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("transfers");
		HttpSession session = req.getSession();
		Client client = (Client)session.getAttribute("user");
		
		if (!as.checkCompatibility(cmbAccountFrom1, txtAccountTo))
		{
			
			mv.addObject("result", false);
			mv.addObject("msg", new String[]{"Debe transferir a una cuenta con la misma moneda"});
			return Transfers(mv, req);
			
		}
		
		Account accFrom = as.getAccount(cmbAccountFrom1);
		Account accTo = as.getAccount(txtAccountTo);
		
		if (accTo == null || accTo.getState()!=2) {
			mv.addObject("result", false);
			mv.addObject("msg", new String[]{"La cuenta destino no existe o esta inactiva"});
			return Transfers(mv, req);
		}
		
		
		if (accFrom.getFunds() <= Float.parseFloat(txtAmmount1)) {
			mv.addObject("result", false);
			mv.addObject("msg", new String[]{"Fondos insuficientes"});
			return Transfers(mv, req);
		}
		
		// realizada
				Transaction t1 = BeanFactory.createTransaction();
				// recibida
				Transaction t2 = BeanFactory.createTransaction();

		
		t1.setState((byte) 1);
		t2.setState((byte) 1);
		float ammount = Float.parseFloat(txtAmmount1);
		t1.setAmmount(ammount);
		t2.setAmmount(ammount);
		t1.setDate(Cmd.crearFecha());
		t2.setDate(Cmd.crearFecha());
		t1.setConcept(txtConcept1);
		t2.setConcept(txtConcept1);
		
		t1.setOriginAccount(accFrom);
		t1.setDestinationAccount(accTo);
		t2.setOriginAccount(accFrom);
		t2.setDestinationAccount(accTo);
		float Saldo = Float.parseFloat(txtAmmount1);
		t1.setTm(ts.getType(3));
		t2.setTm(ts.getType(4));
		
		float nuevoSaldo = accFrom.getFunds() - Saldo;
		t1.setHistory(nuevoSaldo);
		as.updateFunds(accFrom.getIdAccount(), nuevoSaldo);	
		nuevoSaldo = accTo.getFunds() + Saldo;
		t2.setHistory(nuevoSaldo);
		as.updateFunds(accTo.getIdAccount(), nuevoSaldo);
		Boolean result;
		if (ts.insertTransaction(t1) && ts.insertTransaction(t2)) {
			result = true;
			
		} else {result = false;}
		
		mv.addObject("result", result);
		mv.addObject("msg", new String[]{"Ha ocurrido un error", "Transaccion realizada con exito a " + accTo.getClient().getFirstName() +" "+ accTo.getClient().getLastName()});
		return Transfers(mv, req);
	}
		
	


	@RequestMapping(value = "clPayment", method = RequestMethod.POST)
	public ModelAndView Payment(int FeePayment, int Loan, String cmbAccPayment, HttpServletRequest req) {
		
		Loan currentLoan = ls.getLoan(Loan);
		Account acc = as.getAccount(cmbAccPayment);
		Account accBank = as.getMasterAccount(true);
		ModelAndView mv = new ModelAndView("loans");
		if (acc.getFunds() < currentLoan.getMonthAmmount()) {
			mv.addObject("result", false);
			mv.addObject("msg", new String[] { "Fondos insuficientes" });
			return Loans(mv, req);
		}

		// realizada
		Transaction t1 = BeanFactory.createTransaction();
		t1.setState((byte) 1);
		float Saldo = currentLoan.getMonthAmmount();
		t1.setAmmount(Saldo);
		t1.setDate(Cmd.crearFecha());
		t1.setConcept("Pago cuota");
		t1.setOriginAccount(acc);
		t1.setDestinationAccount(accBank);
		t1.setTm(ts.getType(2));

		float nuevoSaldo = acc.getFunds() - Saldo;
		t1.setHistory(nuevoSaldo);
		as.updateFunds(acc.getIdAccount(), nuevoSaldo);
		nuevoSaldo = accBank.getFunds() + Saldo;
		as.updateFunds(accBank.getIdAccount(), nuevoSaldo);
		Boolean result = ts.insertTransaction(t1);

		if(result)
			result = ls.Payment(Loan, FeePayment);
		
		mv.addObject("result", result); // true bien, false mal
		mv.addObject("msg", new String[] { "Opps... ha ocurrido un error", "El pago se ha realizado correctamente" });
		return Loans(mv, req);
	}
	
	@RequestMapping(value = "checkCBU", method = RequestMethod.GET)
	@ResponseBody
	public String checkDni(String cbu) {
		Gson json = new Gson();
		Account acc = as.getAccount(cbu);
		if (acc != null) {
			return json.toJson(acc.getClient(), Client.class);
		}
		return "{\"existe\": false}";

	}

}
