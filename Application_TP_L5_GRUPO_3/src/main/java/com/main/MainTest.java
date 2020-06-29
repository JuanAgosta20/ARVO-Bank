package com.main;



import com.Dao.*;
import com.Model.*;

public class MainTest {

	public static void main(String[] args) {
		
		AccountDao ld = new AccountDaoImpl();
		for(Account f : ld.getAccountsFrom(3)) {
			System.out.println(f.getIdAccount());
		}
		
		
	}

}
