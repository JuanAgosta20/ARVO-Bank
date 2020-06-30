package com.Services;

import java.util.ArrayList;

import com.Model.City;
import com.Model.Countrie;
import com.Model.Province;

public interface LocationService {
	public ArrayList<Countrie> getAllCountries();
	public Countrie getCountrie(int id);
	public ArrayList<Province> getAllProvince();
	public City getCity(String id);
	public City getCity(String name, int idProvince);
	public Boolean saveCity(City city);
	public Province getProvince(Integer id);
	public Province getProvinceApi(int id);
	public Countrie getCountrie(Integer id);
	public Province getProvince(int id);

}
