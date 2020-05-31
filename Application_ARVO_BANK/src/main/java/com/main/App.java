package com.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Controller.Utilities;
import com.Model.Account;
import com.Model.Administrative;
import com.Model.Client;
import com.Model.Connection;
import com.Model.FeePayment;
import com.Model.Transaction;
import com.Model.User;

public class App {

	public static void main(String[] args) {

		Utilities ut = new Utilities();
		SessionFactory sf = Connection.getInstance();
		try {
			Session session = sf.openSession();
			session.beginTransaction();

			// USUARIO
			User user = ut.createUser("123456", "Carlos", "Cliente", (byte) 1);

			User admin = ut.createUser("123456", "Juanchiturre", "Admin", (byte) 1);

			
			// CUENTA
			Account acc = ut.createAccount("12321323213", new Date(), 32323.4F, "Cuenta 1", (byte) 1, null, null,
					"Caja de ahorro");

			
			
			// TRANSACCION
			Calendar cal = Calendar.getInstance();
			cal.set(2020, 5, 12);
			cal.set(Calendar.HOUR_OF_DAY, 12);
			cal.set(Calendar.MINUTE, 12);
			cal.set(Calendar.SECOND, 33);
			Transaction trans = ut.createTransaction(200F, "Pagos", cal.getTime(), (byte) 1, null);
			trans.setDestinationAccount(acc);
			ArrayList<Transaction> hisTrans = new ArrayList<Transaction>();
			hisTrans.add(trans);

			
			//CUENTAS
			ArrayList<Account> lista = new ArrayList<Account>();
			//Aca agrego las transacciones
			acc.setTransactionMade(hisTrans);
			lista.add(acc);
			

			
			
			// CLIENTE
			Client client = ut.createClient(new Date(), "Beccar", "32235422", "carlos@gmail.com", "Carlos", "Rodriguez",
					"Argentina", "Buenos Aires", true, (byte) 1, user, lista);

			
			
			// USUARIO BANCO
			Administrative adm = new Administrative();
			adm.setDni("22365986");
			adm.setEmail("Juancho@hotmail.es");
			adm.setFirst_name("Juan");
			adm.setLast_name("Acosta");
			adm.setState(Byte.parseByte("1"));
			adm.setUser(admin);

			
			
			// CUOTAs
			FeePayment fp = new FeePayment();
			fp.setDate(new Date());
			fp.setLoanId(1);

			
			
			// GUARDAR
			session.save(client);
			session.save(fp);
			session.save(adm);
			session.getTransaction().commit();
			session.close();
			sf.close();
		} catch (Exception ex) {
			System.err.println("Problem in Open Session." + ex);
		}
	}
}
