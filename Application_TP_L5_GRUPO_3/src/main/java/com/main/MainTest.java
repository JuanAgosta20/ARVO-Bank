package com.main;



import com.Dao.*;
import com.Model.*;

public class MainTest {

	public static void main(String[] args) {
		
		AccountDao ld = new AccountDaoImpl();
		System.out.println(ld.getCountAccounts(5));
		
	}

}
