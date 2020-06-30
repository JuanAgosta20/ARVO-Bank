package com.Dao;

import java.util.ArrayList;

import com.Model.City;
import com.Model.Countrie;
import com.Model.Province;

public interface LocationDao {
	
	public ArrayList<Countrie> getAllCountries();
	public Countrie getCountrie(int id);
	public ArrayList<Province> getAllProvinces();
	public City getCity(String id);
	public Boolean saveCity(City city);
	public Province getProvince(Integer id);
	public Countrie getCoountry(Integer id);
}
