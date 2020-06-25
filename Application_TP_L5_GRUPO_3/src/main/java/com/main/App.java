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
import com.Model.Genre;
import com.Model.Loan;
import com.Model.Transaction;
import com.Model.User;
import com.Model.typeAccount;
import com.Model.typeMove;
import com.Model.Cmd;

public class App {

	public static void main(String[] args) {

		SessionFactory sf = Connection.getInstance();
		try {
			Session session = sf.openSession();
			session.beginTransaction();

			// USUARIOs
			User user = Utilities.createUser("123456", "Carlos", "Cliente");
			User user2 = Utilities.createUser("123456", "Pablo", "Cliente");
			User user3 = Utilities.createUser("123456", "Ellen", "Cliente");
			User user4 = Utilities.createUser("123456", "Sundar", "Cliente");
			User user5 = Utilities.createUser("123456", "David", "Cliente");
			User user6 = Utilities.createUser("123456", "Hermann", "Cliente");
			User user7 = Utilities.createUser("123456", "Alexis", "Cliente");
			User user8 = Utilities.createUser("123456", "Alberto", "Cliente");
			User user9 = Utilities.createUser("123456", "Curtis", "Cliente");
			User user10 = Utilities.createUser("123456", "Kevin", "Cliente");

			User admin = Utilities.createUser("123456", "Juanc", "Admin");
			
			typeAccount ta = Utilities.createTypeAccount("Caja de Ahorro en Pesos");
			typeAccount ta2 = Utilities.createTypeAccount("Caja de Ahorro en Dólares");
			typeAccount ta3 = Utilities.createTypeAccount("Cuenta Corriente");
			typeAccount ta4 = Utilities.createTypeAccount("Cuenta Corriente Especial en Pesos");
			typeAccount ta5 = Utilities.createTypeAccount("Cuenta Corriente Especial en Dólares");

			// CUENTA
			Date fecha = Cmd.crearFechaHora(10, 5, 2020, 12, 12, 12);
			Account acc = Utilities.createAccount("12321323213", fecha, 32323.4F, "Cuenta 1", (byte) 1, null, null,
					ta);
			fecha = Cmd.crearFechaHora(10, 1, 2019, 10, 22, 12);
			Account acc2 = Utilities.createAccount("68686868686545", fecha, 45000F, "Cuenta 2", (byte) 1, null, null,
					ta3);
			fecha = Cmd.crearFechaHora(22, 2, 2020, 31, 2, 12);
			Account acc3 = Utilities.createAccount("5473767373356", fecha, 333.03F, "Cuenta 3", (byte) 1, null, null,
					ta4);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc4 = Utilities.createAccount("59598123156651", fecha, 90000.50F, "Cuenta 1", (byte) 1, null, null,
					ta3);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc5 = Utilities.createAccount("323269444845261", fecha, 10000000F, "Cuenta 2", (byte) 1, null,
					null, ta);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc6 = Utilities.createAccount("2215198431218912", fecha, 51510F, "Cuenta 3", (byte) 1, null, null,
					ta2);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc7 = Utilities.createAccount("454612354984561", fecha, 100000F, "Cuenta 1", (byte) 1, null, null,
					ta);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc8 = Utilities.createAccount("5954841631566", fecha, 45.5F, "Cuenta 1", (byte) 1, null, null,
					ta);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc9 = Utilities.createAccount("88451231561231", fecha, 102000.3F, "Cuenta 1", (byte) 1, null, null,
					ta3);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc10 = Utilities.createAccount("99218913621", fecha, 5.5F, "Cuenta 1", (byte) 1, null, null,
					ta);
			
			
			//TIPOS DE MOVIMIENTO
			typeMove tm = Utilities.createTypeMove("Alta de Cuenta", true);
			typeMove tm2 = Utilities.createTypeMove("Alta de Prestamo", true);
			typeMove tm3 = Utilities.createTypeMove("Pago de Prestamo", false);
			typeMove tm4 = Utilities.createTypeMove("Transferencia Realizada", false);
			typeMove tm5 = Utilities.createTypeMove("Transferencia Recibida", true);

			// TRANSACCION
			Date date = Cmd.crearFechaHora(10, 5, 2020, 12, 12, 12);
			Transaction trans = Utilities.createTransaction(2000F, "Pagos", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Transaction trans2 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(25, 3, 2019, 11, 42, 12);
			Transaction trans3 = Utilities.createTransaction(2500F, "Alquiler", date, null, null, tm4);
			date = Cmd.crearFechaHora(15, 4, 2020, 18, 45, 12);
			Transaction trans4 = Utilities.createTransaction(45000F, "Pago cuota", date, null, null,tm2);
			date = Cmd.crearFechaHora(30, 1, 2020, 10, 45, 45);
			Transaction trans5 = Utilities.createTransaction(10000F, "Otros", date, null, null,tm5);
			date = Cmd.crearFechaHora(18, 5, 2019, 12, 12, 23);
			Transaction trans6 = Utilities.createTransaction(2666F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 2, 2020, 19, 46, 22);
			Transaction trans7 = Utilities.createTransaction(25000F, "Transaccion", date, null, null, tm5);
			date = Cmd.crearFechaHora(10, 3, 2020, 11, 45, 12);
			Transaction trans8 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 4, 2020, 10, 00, 12);
			Transaction trans9 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 5, 2020, 19, 00, 01);
			Transaction trans10 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);

			trans.setDestinationAccount(acc);
			trans.setOriginAccount(acc2);

			trans2.setDestinationAccount(acc);
			trans2.setOriginAccount(acc5);

			trans3.setDestinationAccount(acc2);
			trans3.setOriginAccount(acc10);

			trans4.setDestinationAccount(acc10);
			trans4.setOriginAccount(acc4);

			trans5.setDestinationAccount(acc5);
			trans5.setOriginAccount(acc6);

			trans6.setDestinationAccount(acc7);
			trans6.setOriginAccount(acc8);

			trans7.setDestinationAccount(acc9);
			trans7.setOriginAccount(acc);

			trans8.setDestinationAccount(acc10);
			trans8.setOriginAccount(acc2);

			trans9.setDestinationAccount(acc7);
			trans9.setOriginAccount(acc6);

			trans10.setDestinationAccount(acc5);
			trans10.setOriginAccount(acc3);

			ArrayList<Transaction> hisTrans = new ArrayList<Transaction>();
			hisTrans.add(trans);
			hisTrans.add(trans2);

			ArrayList<Transaction> hisTrans2 = new ArrayList<Transaction>();
			hisTrans2.add(trans3);

			ArrayList<Transaction> hisTrans5 = new ArrayList<Transaction>();
			hisTrans5.add(trans5);
			hisTrans5.add(trans10);

			ArrayList<Transaction> hisTrans7 = new ArrayList<Transaction>();
			hisTrans7.add(trans6);
			hisTrans7.add(trans9);

			ArrayList<Transaction> hisTrans9 = new ArrayList<Transaction>();
			hisTrans9.add(trans7);

			ArrayList<Transaction> hisTrans10 = new ArrayList<Transaction>();
			hisTrans10.add(trans4);
			hisTrans10.add(trans8);

			// CUENTAS

			// Aca agrego las transaccion
			acc.setTransactionMade(hisTrans);
			acc2.setTransactionMade(hisTrans2);
			acc5.setTransactionMade(hisTrans5);
			acc7.setTransactionMade(hisTrans7);
			acc9.setTransactionMade(hisTrans9);
			acc10.setTransactionMade(hisTrans10);

			ArrayList<Account> lista = new ArrayList<Account>();
			lista.add(acc);
			lista.add(acc2);
			lista.add(acc3);
			ArrayList<Account> lista2 = new ArrayList<Account>();
			lista2.add(acc4);
			lista2.add(acc5);
			lista2.add(acc6);
			ArrayList<Account> lista3 = new ArrayList<Account>();
			lista3.add(acc7);
			ArrayList<Account> lista4 = new ArrayList<Account>();
			lista4.add(acc8);
			ArrayList<Account> lista5 = new ArrayList<Account>();
			lista5.add(acc9);
			ArrayList<Account> lista6 = new ArrayList<Account>();
			lista6.add(acc10);

			ArrayList<Account> def = new ArrayList<Account>();
			
			Genre gen = Utilities.createGenre("Female");
			Genre gen2 = Utilities.createGenre("Male");
			Genre gen3 = Utilities.createGenre("Undefined");

			// CLIENTE
			Client client = Utilities.createClient(new Date(), "Beccar", "32235422", "carlos@gmail.com", "Carlos",
					"Rodriguez", "Argentina", "Buenos Aires", gen3, user, lista);
			Client client2 = Utilities.createClient(new Date(), "Escobar", "23232323", "pablo@gmail.com", "Pablo",
					"Escobar", "Colombia", "Medellin", gen2, user2, lista2);

			Client client3 = Utilities.createClient(Cmd.crearFecha(6, 12, 1980), "Escobar", "18654923",
					"Eabel@gmail.com", "Ellen", "Abel", "Argentina", "Buenos Aires", gen, user3, lista3);

			Client client4 = Utilities.createClient(Cmd.crearFecha(3, 8, 1985), "Tigre", "23654956", "Sande@gmail.com",
					"Sundar", "Ande", "Argentina", "Buenos Aires", gen3, user4, lista4);

			Client client5 = Utilities.createClient(Cmd.crearFecha(14, 6, 1989), "Garin", "24632589",
					"daustin@gmail.com", "David", "Austin", "Argentina", "Buenos Aires", gen2, user5, lista5);

			Client client6 = Utilities.createClient(Cmd.crearFecha(22, 1, 1990), "Congreso", "30652987",
					"hbaer@gmail.com", "Hermann", "Baer", "Argentina", "Buenos Aires", gen2, user6, lista6);

			Client client7 = Utilities.createClient(Cmd.crearFecha(19, 5, 1992), "Tigre", "35621785", "abull@gmail.com",
					"Alexis", "Bull", "Argentina", "Buenos Aires", gen, user7, def);

			Client client8 = Utilities.createClient(Cmd.crearFecha(28, 2, 1996), "Córdoba", "39632541",
					"aerrazur@gmail.com", "Alberto", "Errazuriz", "Argentina", "Córdoba", gen2, user8, def);

			Client client9 = Utilities.createClient(Cmd.crearFecha(2, 2, 1998), "Formosa", "35621478",
					"cdavies@gmail.com", "Curtis", "Davies", "Argentina", "Formosa", gen2, user9, def);

			Client client10 = Utilities.createClient(Cmd.crearFecha(13, 8, 1997), "Santa Rosa", "40654951",
					"kfeeney@gmail.com", "Kevin", "Feeney", "Argentina", "La Pampa", gen3, user10, def);

			// USUARIO BANCO
			Administrative adm = Utilities.createAdministrative("22365986", "Juancho@hotmail.es", "Juan", "Acosta",
					admin);
			//Administrative adm2 = Utilities.createAdministrative("33009922", "jony@hotmail.es", "Jonathan", "Aceite",
			//		admin);

			// PRESTAMO
			Loan loan = Utilities.createLoan(client, 2323F, date, 3, 774.33F);
			date = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Loan loan2 = Utilities.createLoan(client, 200F, date, 1, 200F);
			date = Cmd.crearFechaHora(10, 2, 2019, 11, 45, 12);
			Loan loan3 = Utilities.createLoan(client, 2000F, date, 1, 2000F);
			date = Cmd.crearFechaHora(12, 1, 2020, 11, 45, 12);
			Loan loan4 = Utilities.createLoan(client, 4500F, date, 3, 1500F);
			date = Cmd.crearFechaHora(4, 1, 2020, 13, 25, 12);
			Loan loan5 = Utilities.createLoan(client, 3000F, date, 3, 1000F);
			date = Cmd.crearFechaHora(1, 1, 2020, 13, 4, 55);
			Loan loan6 = Utilities.createLoan(client, 6000F, date, 3, 2000F);
			date = Cmd.crearFechaHora(10, 3, 2020, 11, 45, 12);
			Loan loan7 = Utilities.createLoan(client, 10000F, date, 1, 10000F);
			date = Cmd.crearFechaHora(16, 2, 2020, 12, 45, 12);
			Loan loan8 = Utilities.createLoan(client, 6000F, date, 1, 6000F);
			date = Cmd.crearFechaHora(18, 2, 2019, 15, 32, 12);
			Loan loan9 = Utilities.createLoan(client, 120000F, date, 3, 40000F);
			date = Cmd.crearFechaHora(9, 2, 2018, 11, 11, 11);
			Loan loan10 = Utilities.createLoan(client, 60000F, date, 3, 20000F);

			// CUOTAs
			FeePayment fp = Utilities.creatFeePayment(loan.getMonthAmmount(), Cmd.crearFechaHora(10, 3, 2020, 12, 11, 11));
			FeePayment fp2 = Utilities.creatFeePayment(loan.getMonthAmmount(), Cmd.crearFechaHora(10, 4, 2020, 15, 33, 11));
			FeePayment fp3 = Utilities.creatFeePayment(loan.getMonthAmmount(), Cmd.crearFechaHora(10, 5, 2020, 13, 55, 11));
			ArrayList<FeePayment> fpList = new ArrayList<FeePayment>();
			fpList.add(fp);
			fpList.add(fp2);
			fpList.add(fp3);
			loan.setPayments(fpList);
			
			ArrayList<FeePayment> fpList2 = new ArrayList<FeePayment>();
			FeePayment fp4 = Utilities.creatFeePayment(loan2.getMonthAmmount(), Cmd.crearFechaHora(10, 3, 2019, 12, 11, 11));
			fpList2.add(fp4);
			loan2.setPayments(fpList2);
			
			ArrayList<FeePayment> fpList3 = new ArrayList<FeePayment>();
			FeePayment fp5 = Utilities.creatFeePayment(loan3.getMonthAmmount(), Cmd.crearFechaHora(12, 2, 2020, 11, 45, 12));
			FeePayment fp6 = Utilities.creatFeePayment(loan3.getMonthAmmount(), Cmd.crearFechaHora(12, 3, 2020, 11, 45, 12));
			FeePayment fp7 = Utilities.creatFeePayment(loan3.getMonthAmmount(), Cmd.crearFechaHora(12, 4, 2020, 11, 45, 12));
			fpList3.add(fp5);
			fpList3.add(fp6);
			fpList3.add(fp7);
			loan4.setPayments(fpList3);
			
			ArrayList<FeePayment> fpList4 = new ArrayList<FeePayment>();
			FeePayment fp8 = Utilities.creatFeePayment(loan3.getMonthAmmount(), Cmd.crearFechaHora(4, 2, 2020, 13, 25, 12));
			FeePayment fp9 = Utilities.creatFeePayment(loan3.getMonthAmmount(), Cmd.crearFechaHora(4, 3, 2020, 9, 25, 12));
			FeePayment fp10 = Utilities.creatFeePayment(loan3.getMonthAmmount(), Cmd.crearFechaHora(4, 4, 2020, 11, 25, 12));
			fpList4.add(fp8);
			fpList4.add(fp9);
			fpList4.add(fp10);
			loan5.setPayments(fpList4);
			
			// TEST AGREGAR CUENTA
			/*
			 * Client cliente = (Client) session.get(Client.class, 1);
			 * ((List<Account>)cliente.getBankAccounts()).add(acc2);
			 * session.update(cliente);
			 */
			//
			session.save(gen);
			session.save(gen2);
			session.save(gen3);
			
			session.save(ta);
			session.save(ta2);
			session.save(ta3);
			session.save(ta4);
			session.save(ta5);
			

			session.save(ta);
			session.save(tm2);
			session.save(tm3);
			session.save(tm4);
			session.save(tm5);

			// GUARDAR
			session.save(trans);
			// Guardando clientes
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
			// --
			session.save(loan);
			session.save(loan2);
			session.save(loan3);
			session.save(loan4);
			session.save(loan5);
			session.save(loan6);
			session.save(loan7);
			session.save(loan8);
			session.save(loan9);
			session.save(loan10);
			session.save(adm);
			//session.save(adm2);
			

			session.getTransaction().commit();
			session.close();
			sf.close();
		} catch (Exception ex) {
			System.err.println("Problem in Open Session." + ex);
		}
	}
}
