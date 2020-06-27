package com.Dao;

import java.util.ArrayList;

import com.Model.Countrie;
import com.Model.Province;

public interface LocationDao {
	
	public ArrayList<Countrie> getAllCountries();
	public ArrayList<Province> getAllProvinces();
	
}
