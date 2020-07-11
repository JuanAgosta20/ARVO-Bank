package com.Services;

import java.util.ArrayList;

import com.Dao.LocationDao;
import com.Model.City;
import com.Model.Countrie;
import com.Model.Province;

public class LocationServiceImpl implements LocationService {


	LocationDao ld;
	
	public LocationServiceImpl(LocationDao ldao) {
		this.ld = ldao;
	}

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
	
	public City getCity(String name, int idProvince) {
		return ld.getCity(name, idProvince);
	}
	
	public Boolean saveCity(City city) {
		return ld.saveCity(city);
	}

	public Province getProvince(Integer id) {
		return ld.getProvince(id);
	}
	public Province getProvinceApi(int id) {
		return ld.getProvinceApi(id);
	}

	public Countrie getCountrie(Integer id) {
		return ld.getCoountry(id);
	}
	public Countrie getCountrie(int id) {
		return ld.getCountrie(id);
	}

	public Province getProvince(int id) {
		return ld.getProvince(id);
	}

}
