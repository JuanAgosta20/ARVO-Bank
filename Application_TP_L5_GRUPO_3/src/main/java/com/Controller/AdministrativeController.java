package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministrativeController {

	@RequestMapping("admClients")
	public ModelAndView Clients(){
		return new ModelAndView("admClients");
	}
	
	@RequestMapping("admAccounts")
	public ModelAndView Accounts(){
		return new ModelAndView("admAccounts");
	}
	
	@RequestMapping("admLoans")
	public ModelAndView Loans(){
		return new ModelAndView("admLoans");
	}
	
	@RequestMapping("admReports")
	public ModelAndView Reports(){
		return new ModelAndView("admReports");
	}
}
