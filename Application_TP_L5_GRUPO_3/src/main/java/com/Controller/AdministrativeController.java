package com.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.ClientDao;
import com.Dao.ClientDaoImpl;
import com.Model.Client;
import com.Model.Province;
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
			Client client = cd.getClient(id);
			MV.addObject("client",client);
			MV.addObject("countries",ls.getAllCountries());
			//ls.getAllProvince().forEach(e->{System.out.println(e.getName());});
			ArrayList<Province> provs =ls.getAllProvince();
;			MV.addObject("provinces", provs);
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