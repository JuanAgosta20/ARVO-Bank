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
			User users[] = new User[10];
			users[0] = Utilities.createUser("123456", "Carlos", "Cliente", (byte) 1);
			users[1] = Utilities.createUser("123456", "Pablo", "Cliente", (byte) 1);
			users[2] = Utilities.createUser("123456", "Marcelo", "Cliente", (byte) 1);
			users[3] = Utilities.createUser("123456", "Jorge", "Cliente", (byte) 1);
			users[4] = Utilities.createUser("123456", "Carolina", "Cliente", (byte) 1);
			users[5] = Utilities.createUser("123456", "Fernanda", "Cliente", (byte) 1);
			users[6] = Utilities.createUser("123456", "Mateo", "Cliente", (byte) 1);
			users[7] = Utilities.createUser("123456", "Laura", "Cliente", (byte) 1);
			users[8] = Utilities.createUser("123456", "Cecilia", "Cliente", (byte) 1);
			users[9] = Utilities.createUser("123456", "Juanchiturre", "Admin", (byte) 1); // admin

			// CUENTA
			Account acc = Utilities.createAccount("12321323213", new Date(), 32323.4F, "Cuenta 1", (byte) 1, null, null,
					"Caja de ahorro");
			Account acc2 = Utilities.createAccount("53574435353", new Date(), 32323.4F, "Cuenta 2", (byte) 1, null,
					null, "Caja de ahorro");

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

			// CUENTAS
			ArrayList<Account> lista = new ArrayList<Account>();
			// Aca agrego las transaccion
			acc.setTransactionMade(hisTrans);
			lista.add(acc);
			ArrayList<Account> lista2 = new ArrayList<Account>();
			lista2.add(acc2);

			// CLIENTE
			Client clients[] = new Client[10];
			clients[0] = Utilities.createClient(new Date(), "Beccar", "32235422", "carlos@gmail.com", "Carlos",
					"Rodriguez", "Argentina", "Buenos Aires", true, (byte) 1, users[0], lista);
			clients[1] = Utilities.createClient(new Date(), "Escobar", "23232323", "pablo@gmail.com", "Pablo",
					"Escobar", "Medellin", "Colombia", true, (byte) 1, users[1], lista2);
			clients[2] = Utilities.createClient(new Date(), "Beccar", "32235422", "marcelo@gmail.com", "Marcelo",
					"Fernandez", "Argentina", "Buenos Aires", true, (byte) 1, users[2], lista);
			clients[3] = Utilities.createClient(new Date(), "Escobar", "23232323", "jorge@gmail.com", "Jorge",
					"Gomez", "Medellin", "Colombia", true, (byte) 1, users[3], lista2);
			clients[4] = Utilities.createClient(new Date(), "Beccar", "32235422", "carolina@gmail.com", "Carolina",
					"Gutierrez", "Argentina", "Buenos Aires", true, (byte) 1, users[4], lista);
			clients[5] = Utilities.createClient(new Date(), "Escobar", "23232323", "fernanda@gmail.com", "Fernanda",
					"Coloccinni", "Medellin", "Colombia", true, (byte) 1, users[5], lista2);
			clients[6] = Utilities.createClient(new Date(), "Beccar", "32235422", "mateo@gmail.com", "Mateo",
					"Ituzaingó", "Argentina", "Buenos Aires", true, (byte) 1, users[6], lista);
			clients[7] = Utilities.createClient(new Date(), "Escobar", "23232323", "laura@gmail.com", "Laura",
					"Gonzales", "Medellin", "Colombia", true, (byte) 1, users[7], lista2);
			clients[8] = Utilities.createClient(new Date(), "Beccar", "32235422", "cecilia@gmail.com", "Cecilia",
					"Lotbrok", "Argentina", "Buenos Aires", true, (byte) 1, users[8], lista);
			clients[9] = Utilities.createClient(new Date(), "Escobar", "23232323", "pablo@gmail.com", "Pablo",
					"Escobar", "Medellin", "Colombia", true, (byte) 1, users[9], lista2);

			// USUARIO BANCO
			Administrative adm = new Administrative();
			adm.setDni("22365986");
			adm.setEmail("Juancho@hotmail.es");
			adm.setFirst_name("Juan");
			adm.setLast_name("Acosta");
			adm.setState(Byte.parseByte("1"));
			adm.setUser(admin);

			// PRESTAMO
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

			// TEST AGREGAR CUENTA
			/*
			 * Client cliente = (Client) session.get(Client.class, 1);
			 * ((List<Account>)cliente.getBankAccounts()).add(acc2);
			 * session.update(cliente);
			 */

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
