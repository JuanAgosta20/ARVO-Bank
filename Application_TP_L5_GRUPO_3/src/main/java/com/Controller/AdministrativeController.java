package com.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import org.hibernate.mapping.Map;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import com.Dao.ClientDao;
import com.Dao.ClientDaoImpl;
import com.Model.BeanFactory;
import com.Model.City;
import com.Model.Client;
import com.Model.Cmd;
import com.Model.Countrie;
import com.Model.Genre;
import com.Model.Province;
import com.Services.ClientService;
import com.Services.ClientServiceImpl;
import com.Services.GenreService;
import com.Services.GenreServiceImpl;
import com.Services.LocationService;
import com.Services.LocationServiceImpl;
import com.google.gson.Gson;
import com.google.protobuf.TextFormat.ParseException;

@Controller
public class AdministrativeController {

	BeanFactory bf = new BeanFactory();
	ClientService cs = bf.createClientServiceImpl();
	LocationService ls =  bf.createLocationServiceImpl();
	GenreService gs = bf.createGenreServiceImpl();

	@RequestMapping(value="admClients", method=RequestMethod.POST)
	public ModelAndView Clients(String name, String lastname, String DNI, String birthdate, 
			Integer countries, Integer province, String cities, String email, Integer genre){
		ModelAndView MV = new ModelAndView("admClients");
		Client client = new Client();
		Province prov = ls.getProvince(province);
		Countrie country = ls.getCountrie(countries);
		City city = ls.getCity(cities);
		Genre gen = gs.getGenre(genre);
		
		if(city == null) {
			city = new City();
			city.setIdCity(cities);
			city.setName(lastname);
			city.setProv(prov);
			ls.saveCity(city);
		}
		
		try {
			if(birthdate != null) client.setBirthdate(Cmd.crearFecha(birthdate));
		}catch(java.text.ParseException ex) {
			ex.printStackTrace();
		}
		client.setFirstName(name);
		client.setLastName(lastname);
		client.setDni(DNI);
		client.setGenre(gen);
		client.setEmail(email);
		client.setNationality(country);
		client.setCity(city);
		client.setProvince(prov);
		
		if(cs.saveClient(client)) MV.addObject("guardo",true);
		else MV.addObject("guardo",false);
		
		MV.addObject("clients",cs.readClients());
		MV.addObject("countries", ls.getAllCountries());
		MV.addObject("province", ls.getAllProvince());
		
		return MV;
	}
	
	@RequestMapping(value="checkEmail",method=RequestMethod.GET)
		@ResponseBody
		public String checkEmail(String email){
			System.out.println("Entro a check email" + email);
			if(cs.emailExist(email)) {
				return "{\"existe\": true}";
			}
			return "{\"existe\": false}";
			
		}
	
	@RequestMapping("admAccounts")
	public ModelAndView Accounts(){
		return new ModelAndView("admAccounts");
	}
	
	@RequestMapping("admClientProfile")
	public ModelAndView ClientProfile(int id){
		ModelAndView MV = new ModelAndView("admClientProfile");
		
		
		try{
			Client client = cs.readClient(id);
			MV.addObject("client",client);
			MV.addObject("countries",ls.getAllCountries());
			MV.addObject("genres",gs.getAllGenres());
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