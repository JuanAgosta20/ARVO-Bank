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
import com.Model.Loan;
import com.Model.Transaction;
import com.Model.User;
import com.Model.Cmd;

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
			
			ArrayList<Account> def = new ArrayList<Account>();
			


			// CLIENTE
			Client client = Utilities.createClient(new Date(), "Beccar", "32235422", "carlos@gmail.com", "Carlos", "Rodriguez",
					"Argentina", "Buenos Aires", true, user, lista);
			Client client2 = Utilities.createClient(new Date(), "Escobar", "23232323", "pablo@gmail.com", "Pablo", "Escobar",
					"Colombia", "Medellin", true, user2, lista2);
			

			Client client3 = Utilities.createClient(Cmd.crearFecha(6, 12, 1980), "Escobar", "18654923", "Eabel@gmail.com", "Ellen", "Abel",
			"Argentina", "Buenos Aires", true, user3, def);

			Client client4 = Utilities.createClient(Cmd.crearFecha(3, 8, 1985), "Tigre", "23654956", "Sande@gmail.com", "Sundar", "Ande",
			"Argentina", "Buenos Aires", true, user4, def);
					
			Client client5 = Utilities.createClient(Cmd.crearFecha(14, 6, 1989), "Garin", "24632589", "daustin@gmail.com", "David", "Austin",
			"Argentina", "Buenos Aires", true, user5, def);
					
			Client client6 = Utilities.createClient(Cmd.crearFecha(22, 1, 1990), "Congreso", "30652987", "hbaer@gmail.com", "Hermann", "Baer",
			"Argentina", "Buenos Aires", true, user6, def);
					
			Client client7 = Utilities.createClient(Cmd.crearFecha(19, 5, 1992), "Tigre", "35621785", "abull@gmail.com", "Alexis", "Bull",
			"Argentina", "Buenos Aires", true, user7, def);
			
			Client client8 = Utilities.createClient(Cmd.crearFecha(28, 2, 1996), "Córdoba", "39632541", "aerrazur@gmail.com", "Alberto", "Errazuriz",
			"Argentina", "Córdoba", true, user8, def);
			
			Client client9 = Utilities.createClient(Cmd.crearFecha(2, 2, 1998), "Formosa", "35621478", "cdavies@gmail.com", "Curtis", "Davies",
			"Argentina", "Formosa", true, user9, def);
			
			Client client10 = Utilities.createClient(Cmd.crearFecha(13, 8, 1997), "Santa Rosa", "40654951", "kfeeney@gmail.com", "Kevin", "Feeney",
			"Argentina", "La Pampa", true, user10, def);
			
			
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
			//Guardando clientes
			session.save(client);
			session.save(client2);
			session.save(client3);
			session.save(client4);
			session.save(client5);
			session.save(client6);
			session.save(client7);
			session.save(client8);
			session.save(client9);
			session.save(client10);
			//--
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
