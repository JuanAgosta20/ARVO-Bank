package com.main;



import com.Dao.*;
import com.Model.*;

public class MainTest {

	public static void main(String[] args) {
		
		AccountDao ld = new AccountDaoImpl();
		for(Account f : ld.getAllUnchekedAccounts()) {
			System.out.println(f.getClient().getFirstName());
		}
		
		
	}

}
