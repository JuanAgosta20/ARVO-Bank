package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.ClientDao;
import com.Dao.ClientDaoImpl;
import com.Services.LocationService;
import com.Services.LocationServiceImpl;

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
	
	@RequestMapping("admClientProfile")
	public ModelAndView ClientProfile(int id){
		ModelAndView MV = new ModelAndView("admClientProfile");
		ClientDao cd = new ClientDaoImpl();
		LocationService ls = new LocationServiceImpl();
		
		try{
			MV.addObject("client",cd.getClient(id));
			MV.addObject("countries",ls.getAllCountries());
			//ls.getAllProvince().forEach(e->{System.out.println(e.getName());});
			MV.addObject("provinces",ls.getAllProvince());
		}catch (Exception e) {
			e.printStackTrace();
			return MV;
		}
		
		return MV;
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