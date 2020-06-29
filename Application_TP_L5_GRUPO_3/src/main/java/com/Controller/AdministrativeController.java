package com.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.ClientDao;
import com.Dao.ClientDaoImpl;
import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.Countrie;
import com.Model.Genre;
import com.Model.Province;
import com.Model.User;
import com.Services.AccountService;
import com.Services.AccountServiceImpl;
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

	BeanFactory bFactory = new BeanFactory();
	BeanFactory bf = new BeanFactory();
	ClientDao cd = new ClientDaoImpl();
	ClientServiceImpl cs = new ClientServiceImpl();
	LocationService ls = new LocationServiceImpl();// bf.createLocationServiceImpl();
	GenreService gs = new GenreServiceImpl(); // bf.createGenreServiceImpl();
	AccountService accs = new AccountServiceImpl();
	UserService us = new UserServiceImpl();

	@RequestMapping("admClients")
	public ModelAndView Clients() {
		ModelAndView MV = new ModelAndView("admClients");
		ClientServiceImpl sClient = bFactory.createClientServiceImpl();

		MV.addObject("clients", sClient.readClients());

		return MV;
	}

	@RequestMapping("admAccounts")
	public ModelAndView Accounts() {
		ModelAndView mv = new ModelAndView("admAccounts");
		mv.addObject("uncheckedAccounts", accs.getAllUnchekedAccounts());
		return mv;
	}

	@RequestMapping(name = "admAccountsState", method = RequestMethod.POST)
	public ModelAndView AccountState(String accept, String reject) {
		ModelAndView mv = new ModelAndView("admAccounts");
		Boolean result = false;
		if (accept != null) {
			result = accs.updateStateAccount(Integer.parseInt(accept), 2);
		} else if (reject != null) {
			result = accs.updateStateAccount(Integer.parseInt(reject), 0);
		}
		mv.addObject("uncheckedAccounts", accs.getAllUnchekedAccounts());

		mv.addObject("result", result); // true bien, false mal
		mv.addObject("msg", new String[] { "Ha ocurrido un error", "Operación realizada correctamente" });

		return mv;
	}

	@RequestMapping("admClientProfile")
	public ModelAndView ClientProfile(int id) {
		ModelAndView MV = new ModelAndView("admClientProfile");

		try {
			Client client = cd.getClient(id);
			MV.addObject("client", client);
			MV.addObject("countries", ls.getAllCountries());
			MV.addObject("genres", gs.getAllGenres());
			// ls.getAllProvince().forEach(e->{System.out.println(e.getName());});
			ArrayList<Province> provs = ls.getAllProvince();
			;
			MV.addObject("provinces", provs);
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
		
	    Date date=new SimpleDateFormat("dd/MM/yyyy").parse(txtDate); 
	    
		User u = us.getUser(txtIdClient);
		Countrie c = ls.getCountry(drpCity);
		Province p = ls.getProvince(drpProvince);
		Genre g = gs.getGenre(drpGenre);
		Client cl = Utilities.createClient(date, drpCity, txtDni, txtEmail, null, null,c , p, g, user);
		= cs.updateClient(client);

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