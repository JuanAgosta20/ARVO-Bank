package com.Controller;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
import com.Dao.Paginator;
import com.Dao.SessionHandler;
import com.Model.Account;
import com.Model.BeanFactory;
import com.Model.City;
import com.Model.Client;
import com.Model.Cmd;
import com.Model.Countrie;
import com.Model.Genre;
import com.Model.Province;
import com.Model.TransactionsPerMonth;
import com.Model.User;
import com.Services.AccountService;
import com.Services.AccountServiceImpl;
import com.Services.ClientService;
import com.Services.ClientServiceImpl;
import com.Services.GenreService;
import com.Services.GenreServiceImpl;
import com.Services.LocationService;
import com.Services.LocationServiceImpl;
import com.Services.TransactionService;
import com.Services.TransactionServiceImpl;
import com.Services.UserService;
import com.Services.UserServiceImpl;
import com.Services.LoanService;
import com.Services.LoanServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.main.Utilities;

@Controller
public class AdministrativeController {

	ClientService cs = BeanFactory.createClientServiceImpl();
	LocationService ls = BeanFactory.createLocationServiceImpl();
	GenreService gs = BeanFactory.createGenreServiceImpl();
	AccountService accs = BeanFactory.createAccountServiceImpl();
	UserService us = BeanFactory.createUserServiceImpl();
	LoanService loanser = new LoanServiceImpl();
	TransactionService ts = BeanFactory.createTransactionServiceImpl();

	
	@RequestMapping(value = "admClientsList")
	public ModelAndView ClientsList(ModelAndView mv) {
		if (mv.isEmpty())
			mv = new ModelAndView("admClients");
		
		mv.addObject("clients", cs.readClients());
		mv.addObject("countries", ls.getAllCountries());
		mv.addObject("province", ls.getAllProvince());

		return mv;
	}

	@RequestMapping(value = "admClients", method = RequestMethod.POST)
	public ModelAndView Clients(String name, String lastname, String DNI, String birthdate, Integer countries,
			Integer province, String cities, String mail, Integer genre, String nameCity, String username) {
		ModelAndView MV = new ModelAndView("admClients");
		Client client = new Client();
		Province prov = ls.getProvince(province);
		Countrie country = ls.getCountrie(countries);
		City city = ls.getCity(cities);
		Genre gen = gs.getGenre(genre);
		User user = new User();

		user.setPassword(DNI);
		user.setUserName(username);
		user.setState((byte) 1);
		user.setUserType("Cliente");

		if (city == null) {
			city = new City();
			city.setIdCity(cities);
			city.setName(nameCity);
			city.setProv(prov);
			ls.saveCity(city);
		}

		try {
			if (birthdate != null)
				client.setBirthdate(Cmd.crearFecha(birthdate));
		} catch (java.text.ParseException ex) {
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
		client.setState((byte) 1);
		client.setUser(user);
		Boolean result;

		if (cs.saveClient(client)) {
			result = true;
		} else {
			result = false;
		}

		MV.addObject("result", result);
		MV.addObject("msg", new String[] { "Ha ocurrido un error", "Operación realizada correctamente" });

		return ClientsList(MV);
	}

	@RequestMapping(value = "checkEmail", method = RequestMethod.GET)
	@ResponseBody
	public String checkEmail(String mail) {
		System.out.println("Entro a check email" + mail);
		if (cs.emailExist(mail)) {
			return "{\"existe\": true}";
		}
		return "{\"existe\": false}";

	}
	
	@RequestMapping(value = "checkDni", method = RequestMethod.GET)
	@ResponseBody
	public String checkDni(String dni) {
		System.out.println("Entro a check email" + dni);
		if (cs.dniExist(dni)) {
			return "{\"existe\": true}";
		}
		return "{\"existe\": false}";

	}

	@RequestMapping(value = "checkUserName", method = RequestMethod.GET)
	@ResponseBody
	public String checkUserName(String username) {
		System.out.println("Entro a check username" + username);
		if (us.existUserName(username)) {
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

	@RequestMapping(value = "admAccountsState", method = RequestMethod.POST)
	public ModelAndView AccountState(String accept, String reject) {
		ModelAndView mv = new ModelAndView("admAccounts");
		Boolean result = false;
		if (accept != null) {
			result = accs.acceptAccount(Integer.parseInt(accept), 2);
		} else if (reject != null) {
			result = accs.deleteAccount(Integer.parseInt(reject));
		}
		mv.addObject("uncheckedAccounts", accs.getAllUnchekedAccounts());

		mv.addObject("result", result); // true bien, false mal
		mv.addObject("msg", new String[] { "Ha ocurrido un error", "Operacion realizada correctamente" });

		return mv;
	}

	@RequestMapping(value = "admDeleteAccount", method = RequestMethod.POST)
	public ModelAndView DeleteAccount(int idAccount, int idClient) {
		ModelAndView mv = new ModelAndView("admClientProfile");
		Boolean result = accs.deleteAccount(idAccount);
		mv.addObject("result", result);
		mv.addObject("msg", new String[] { "Ha ocurrido un error", "La eliminacion fue realizada correctamente" });
		return ClientProfile(idClient, mv);
	}

	@RequestMapping("admClientProfile")

	public ModelAndView ClientProfile(int id, ModelAndView MV) {
		if (MV.isEmpty())
			MV = new ModelAndView("admClientProfile");

		try {
			Client client = cs.readClient(id);
			MV.addObject("accounts", accs.getAccountsFrom(client.getIdClient()));
			MV.addObject("loans", loanser.getLoansFrom(client.getIdClient()));
			MV.addObject("client", client);
			MV.addObject("countries", ls.getAllCountries());
			MV.addObject("genres", gs.getAllGenres());
			ArrayList<Province> provs = ls.getAllProvince();
			MV.addObject("provinces", provs);
		} catch (Exception e) {
			e.printStackTrace();
			return MV;
		}

		return MV;
	}

	@RequestMapping(value = "admUpdateClient", method = RequestMethod.POST)
	public ModelAndView UpdateClient(String txtDni, int drpGenre, String txtEmail, String txtDate, int drpCountry,
			int drpProvince, String drpCity, String txtIdCity, String txtUser, String txtPass, int txtIdClient) {
		ModelAndView MV = new ModelAndView();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Genre g = gs.getGenre(drpGenre);
		Countrie n = ls.getCountrie(drpCountry);
		Province p = ls.getProvinceApi(drpProvince);
		City city = ls.getCity(drpCity);
		if (city == null) {
			city = new City();
			city.setIdCity(drpCity);
			city.setName(txtIdCity);
			city.setProv(p);
			ls.saveCity(city);
		}
		Client c = cs.readClient(txtIdClient);
		c.getUser().setPassword(txtPass);
		c.getUser().setUserName(txtUser);
		c.setBirthdate(date);
		c.setDni(txtDni);
		c.setEmail(txtEmail);
		c.setGenre(g);
		c.setNationality(n);
		c.setProvince(p);
		c.setCity(city);

		cs.updateClient(c);
		MV.setViewName("redirect:admClientProfile.do?id=" + txtIdClient);
		return MV;
	}

	@RequestMapping("admDeleteClient")
	public ModelAndView DeleteClient(int idClient, int idUser) {
		ModelAndView MV = new ModelAndView("redirect:admClientsList.do");
		Boolean result = cs.deleteClient(idClient, idUser);
		MV.addObject("result", result);
		MV.addObject("msg", new String[] { "Ha ocurrido un error", "La eliminación fue realizada correctamente" });
		return ClientsList(MV);
	}

	@RequestMapping("admLoans")
	public ModelAndView Loans(ModelAndView mv) {
		if(mv.isEmpty())
			mv = new ModelAndView("admLoans");
		mv.addObject("loans", loanser.getAllUnchekedLoans());
		return mv;
	}
	
	@RequestMapping("checkLoan")
	public ModelAndView checkLoan(String accept, String reject) {
		ModelAndView mv = new ModelAndView("admLoans");
		Boolean result = false;
		if (accept != null) {
			result = loanser.acceptLoan(Integer.parseInt(accept), 2);
			//Hacer la transferencia de plata
		} else if (reject != null) {
			result = loanser.deleteLoan(Integer.parseInt(reject));
		}
		mv.addObject("result", result); // true bien, false mal
		mv.addObject("msg", new String[] { "Ha ocurrido un error", "Operacion realizada correctamente" });

		return Loans(mv);
	}

	@RequestMapping("admReports")
	public ModelAndView Reports() {
		return new ModelAndView("admReports");
	}

	@RequestMapping(value = "getTransfers", method = RequestMethod.GET)
	@ResponseBody
	public String getTransfers(String init, String end) {
		System.out.println("Entro a check username" + init + end);
		// Esto se reemplaza y va en dao
		
		
		
		try {
			ArrayList<BigInteger> arr = ts.getTransactionsBetween(init, end);
			ArrayList<String> arr2 = ts.getTransactionsBetweenName(init, end);
			ArrayList<TransactionsPerMonth> arrTrans = new ArrayList<TransactionsPerMonth>();
			for (int i = 0; i < arr.size(); i++) {
				TransactionsPerMonth tp = new TransactionsPerMonth();
				tp.setMonthName(arr2.get(i).toString());
				tp.setQuantity(arr.get(i));
				arrTrans.add(tp);
			}
			String json = new Gson().toJson(arrTrans);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			return null;
		}

		/*
		 * query SELECT DATE_FORMAT(date, '%m') as 'month', COUNT(idTrans) as 'total'
		 * FROM transactions where (date BETWEEN '2020-01-01' AND '2020-12-31') GROUP BY
		 * DATE_FORMAT(date, '%m')
		 */

	}
	
}