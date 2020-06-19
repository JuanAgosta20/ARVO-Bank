package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministrativeController {

	@RequestMapping("clients")
	public ModelAndView Clients(){
		return new ModelAndView("admClients");
	}
	
	@RequestMapping("accounts")
	public ModelAndView Accounts(){
		return new ModelAndView("admAccounts");
	}
	
	@RequestMapping("loans")
	public ModelAndView Loans(){
		return new ModelAndView("admLoans");
	}
	
	@RequestMapping("reports")
	public ModelAndView Reports(){
		return new ModelAndView("admReports");
	}
}
