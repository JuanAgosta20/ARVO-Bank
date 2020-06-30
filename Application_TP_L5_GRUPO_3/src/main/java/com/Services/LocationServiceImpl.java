package com.Services;

import java.util.ArrayList;

import com.Dao.LocationDao;
import com.Dao.LocationDaoImpl;
import com.Model.BeanFactory;
import com.Model.City;
import com.Model.Countrie;
import com.Model.Province;

public class LocationServiceImpl implements LocationService {

	
	LocationDao ld = new LocationDaoImpl();

	public ArrayList<Countrie> getAllCountries() {
		return ld.getAllCountries();
	}

	public ArrayList<Province> getAllProvince() {
		return ld.getAllProvinces();
	}

	public ArrayList<Province> getAllProvince(Integer country) {
		return ld.getAllProvinces();
	}

	public City getCity(String id) {
		return ld.getCity(id);
	}
	
	public Boolean saveCity(City city) {
		return ld.saveCity(city);
	}

	public Province getProvince(Integer id) {
		return ld.getProvince(id);
	}

	public Countrie getCountrie(Integer id) {
		ld.getCoountry(id);
		return null;
	}
}
