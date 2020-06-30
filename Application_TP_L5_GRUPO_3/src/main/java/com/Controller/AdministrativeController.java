package com.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import com.Model.Account;
import com.Model.BeanFactory;
import com.Model.City;
import com.Model.Client;
import com.Model.Cmd;
import com.Model.Countrie;
import com.Model.Genre;
import com.Model.Province;
import com.Model.User;
import com.Services.AccountService;
import com.Services.AccountServiceImpl;
import com.Services.ClientService;
import com.Services.ClientServiceImpl;
import com.Services.GenreService;
import com.Services.GenreServiceImpl;
import com.Services.LocationService;
import com.Services.LocationServiceImpl;
import com.Services.UserService;
import com.Services.UserServiceImpl;
import com.main.Utilities;

@Controller
public class AdministrativeController {

	BeanFactory bf = new BeanFactory();

	ClientService cs = bf.createClientServiceImpl();
	LocationService ls =  bf.createLocationServiceImpl();
	GenreService gs = bf.createGenreServiceImpl();
	AccountService accs = new AccountServiceImpl();
	


	@RequestMapping(value="admClients", method=RequestMethod.POST)
	public ModelAndView Clients(String name, String lastname, String DNI, String birthdate, 
			Integer countries, Integer province, String cities, String mail, Integer genre){
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
		client.setEmail(mail);
		client.setNationality(country);
		client.setCity(city);
		client.setProvince(prov);
		client.setState((byte)1);
		
		if(cs.saveClient(client)) MV.addObject("guardo",true);
		else MV.addObject("guardo",false);
		
		MV.addObject("clients",cs.readClients());
		MV.addObject("countries", ls.getAllCountries());
		MV.addObject("province", ls.getAllProvince());
		
		return MV;
	}
	
	@RequestMapping(value="checkEmail",method=RequestMethod.GET)
		@ResponseBody
		public String checkEmail(String mail){
			System.out.println("Entro a check email" + mail);
			if(cs.emailExist(mail)) {
				return "{\"existe\": true}";
			}
			return "{\"existe\": false}";
			
		}
	@RequestMapping("admAccounts")
	public ModelAndView Accounts() {
		ModelAndView mv = new ModelAndView("admAccounts");
		mv.addObject("uncheckedAccounts", accs.getAllUnchekedAccounts());
		return mv;
	}

	@RequestMapping(value="admAccountsState", method = RequestMethod.POST)
	public ModelAndView AccountState(String accept, String reject){
		ModelAndView mv = new ModelAndView("admAccounts");
		Boolean result = false;
		if(accept != null) {
			result = accs.acceptAccount(Integer.parseInt(accept), 2);
		}else if(reject != null) {
			result = accs.acceptAccount(Integer.parseInt(reject), 0);
		}
		mv.addObject("uncheckedAccounts", accs.getAllUnchekedAccounts());

		mv.addObject("result", result); // true bien, false mal
		mv.addObject("msg", new String[] { "Ha ocurrido un error", "Operación realizada correctamente" });

		return mv;
	}
	
	@RequestMapping(value="admDeleteAccount", method=RequestMethod.POST)
	public ModelAndView DeleteAccount(int idAccount, int idClient) {
		ModelAndView mv = new ModelAndView("admClientProfile");
		Boolean result = accs.deleteAccount(idAccount);
		mv.addObject("result", result);
		mv.addObject("msg", new String[] { "Ha ocurrido un error", "La eliminación fue realizada correctamente" });
		return ClientProfile(idClient, mv);
	}

	@RequestMapping("admClientProfile")

	public ModelAndView ClientProfile(int id, ModelAndView MV) {
		if(MV.isEmpty())
			MV = new ModelAndView("admClientProfile");

		try {
			Client client = cs.readClient(id);
			MV.addObject("client", client);
			MV.addObject("countries", ls.getAllCountries());
			MV.addObject("genres", gs.getAllGenres());
			ArrayList<Province> provs = ls.getAllProvince();
			MV.addObject("provinces", provs);
			ArrayList<Account> acc = accs.getAccountsFrom(client.getIdClient());
			MV.addObject("accounts", acc);
		} catch (Exception e) {
			e.printStackTrace();
			return MV;
		}

		return MV;
	}

	@RequestMapping(value = "admUpdateClient", method = RequestMethod.POST)
	public ModelAndView UpdateClient(String txtDni, int drpGenre, String txtEmail, String txtDate, int drpCountry,
			int drpProvince, String drpCity, String txtUser, String txtPass, int txtIdClient) {
		ModelAndView MV = new ModelAndView();
		Date date = null;
	    try {
				date=new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	    Genre g = gs.getGenre(drpGenre);
	    Countrie n = ls.getCountrie(drpCountry);
	    Province p = ls.getProvince(drpProvince);
	    Client c = cs.readClient(txtIdClient);
	    c.getUser().setPassword(txtPass);
	    c.getUser().setUserName(txtUser);
	    c.setBirthdate(date);
	    c.setDni(txtDni);
	    c.setEmail(txtEmail);
	    c.setGenre(g);
	    c.setNationality(n);
	    c.setProvince(p);
	    
	    cs.updateClient(c);
	    MV.setViewName("redirect:admClientProfile.do?id="+txtIdClient);
		return MV;
	}

	@RequestMapping("admDeleteClient")
	public ModelAndView DeleteClient(int idClient, int idUser) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admClients");
		cs.deleteClient(idClient, idUser);

		return MV;
	}

	@RequestMapping("admLoans")
	public ModelAndView Loans() {
		return new ModelAndView("admLoans");
	}

	@RequestMapping("admReports")
	public ModelAndView Reports() {
		return new ModelAndView("admReports");
	}
}