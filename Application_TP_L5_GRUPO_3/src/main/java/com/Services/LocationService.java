package com.Services;

import java.util.ArrayList;

import com.Model.Countrie;
import com.Model.Province;

public interface LocationService {
	public ArrayList<Countrie> getAllCountries();
	public ArrayList<Province> getAllProvince();

}
