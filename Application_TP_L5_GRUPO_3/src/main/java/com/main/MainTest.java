package com.main;



import com.Dao.*;
import com.Model.*;

public class MainTest {

	public static void main(String[] args) {
		
		LoanDao ld = new LoanDaoImpl();
		ld.getLoansFrom(1).forEach(x -> {
			System.out.println(x.getLoanId());
		});
		
		
	}

}
