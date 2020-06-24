package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientsController {
	
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
}
