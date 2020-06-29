package com.Services;

import java.util.ArrayList;

import com.Dao.LocationDao;
import com.Model.BeanFactory;
import com.Model.Countrie;
import com.Model.Province;

public class LocationServiceImpl implements LocationService {

	BeanFactory bf = new BeanFactory();
	LocationDao ld = bf.createLocationDaoImpl();

	public ArrayList<Countrie> getAllCountries() {
		return ld.getAllCountries();
	}

	public ArrayList<Province> getAllProvince() {
		return ld.getAllProvinces();
	}

	public Countrie getCountrie(int id) {
		return ld.getCountrie(id);
	}

	public Province getProvince(int id) {
		return ld.getProvince(id);
	}

}
