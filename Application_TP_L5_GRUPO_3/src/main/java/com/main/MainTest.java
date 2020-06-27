package com.main;



import com.Dao.LocationDao;
import com.Dao.LocationDaoImpl;
import com.Model.Province;

public class MainTest {

	public static void main(String[] args) {
		
		LocationDao ld = new LocationDaoImpl();
		for(Province f : ld.getAllProvinces()) {
			System.out.println(f.getName());
		}
		
		
	}

}
