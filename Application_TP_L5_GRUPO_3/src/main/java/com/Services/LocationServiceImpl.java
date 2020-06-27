package com.Services;

import java.util.ArrayList;

import com.Dao.LocationDao;
import com.Dao.LocationDaoImpl;
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

}
