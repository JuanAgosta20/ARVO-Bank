package com.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Controller.Utilities;
import com.Model.Account;
import com.Model.Administrative;
import com.Model.Client;
import com.Model.Connection;
import com.Model.FeePayment;
import com.Model.Loan;
import com.Model.Transaction;
import com.Model.User;

public class App {

	public static void main(String[] args) {

		SessionFactory sf = Connection.getInstance();
		try {
			Session session = sf.openSession();
			session.beginTransaction();

			// USUARIO
			User user = Utilities.createUser("123456", "Carlos", "Cliente", (byte) 1);
			User user2 = Utilities.createUser("123456", "Pablo", "Cliente", (byte) 1);

			User admin = Utilities.createUser("123456", "Juanchiturre", "Admin", (byte) 1);

			
			// CUENTA
			Account acc = Utilities.createAccount("12321323213", new Date(), 32323.4F, "Cuenta 1", (byte) 1, null, null,
					"Caja de ahorro");
			Account acc2 = Utilities.createAccount("53574435353", new Date(), 32323.4F, "Cuenta 2", (byte) 1, null, null,
					"Caja de ahorro");

			
			
			// TRANSACCION
			Calendar cal = Calendar.getInstance();
			cal.set(2020, 5, 12);
			cal.set(Calendar.HOUR_OF_DAY, 12);
			cal.set(Calendar.MINUTE, 12);
			cal.set(Calendar.SECOND, 33);
			Transaction trans = Utilities.createTransaction(2000F, "Pagos", cal.getTime(), (byte) 1, null, null);
			trans.setDestinationAccount(acc);
			trans.setOriginAccount(acc2);
			ArrayList<Transaction> hisTrans = new ArrayList<Transaction>();
			hisTrans.add(trans);

			
			//CUENTAS
			ArrayList<Account> lista = new ArrayList<Account>();
			//Aca agrego las transaccion
			acc.setTransactionMade(hisTrans);
			lista.add(acc);
			ArrayList<Account> lista2 = new ArrayList<Account>();
			lista2.add(acc2);
			
			

			
			
			// CLIENTE
			Client client = Utilities.createClient(new Date(), "Beccar", "32235422", "carlos@gmail.com", "Carlos", "Rodriguez",
					"Argentina", "Buenos Aires", true, (byte) 1, user, lista);
			Client client2 = Utilities.createClient(new Date(), "Escobar", "23232323", "pablo@gmail.com", "Pablo", "Escobar",
					"Medellin", "Colombia", true, (byte) 1, user2, lista2);

			
			
			// USUARIO BANCO
			Administrative adm = new Administrative();
			adm.setDni("22365986");
			adm.setEmail("Juancho@hotmail.es");
			adm.setFirst_name("Juan");
			adm.setLast_name("Acosta");
			adm.setState(Byte.parseByte("1"));
			adm.setUser(admin);

			//PRESTAMO
			Loan loan = new Loan();
			loan.setAmmount(2323f);
			loan.setClient(client);
			loan.setDate(new Date());
			loan.setFees(12);
			loan.setMonthAmmount(2323f);
			
			// CUOTAs
			FeePayment fp = new FeePayment();
			fp.setDate(new Date());
			ArrayList<FeePayment> fpList = new ArrayList<FeePayment>();
			fpList.add(fp);
			loan.setPayments(fpList);

			
			//TEST AGREGAR CUENTA
			/* Client cliente = (Client) session.get(Client.class, 1);
			((List<Account>)cliente.getBankAccounts()).add(acc2);
			session.update(cliente);*/
			
			// GUARDAR
			session.save(trans);
			session.save(client);
			session.save(client2);
			session.save(loan);
			session.save(adm);
			
			session.getTransaction().commit();
			session.close();
			sf.close();
		} catch (Exception ex) {
			System.err.println("Problem in Open Session." + ex);
		}
	}
}
