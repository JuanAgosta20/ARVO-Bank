package com.Dao;

import java.util.ArrayList;

import com.Model.Countrie;
import com.Model.Province;

public interface LocationDao {
	
	public ArrayList<Countrie> getAllCountries();
	public Countrie getCountrie(int id);
	public ArrayList<Province> getAllProvinces();
	public Province getProvince(int id);
	
}
