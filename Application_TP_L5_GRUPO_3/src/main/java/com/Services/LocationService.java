package com.Services;

import java.util.ArrayList;

import com.Model.City;
import com.Model.Countrie;
import com.Model.Province;

public interface LocationService {
	public ArrayList<Countrie> getAllCountries();
	public ArrayList<Province> getAllProvince();
	public City getCity(String id);
	public Boolean saveCity(City city);
	public Province getProvince(Integer id);
	public Countrie getCountrie(Integer id);

}
