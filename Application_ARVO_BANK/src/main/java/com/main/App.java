package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.Connection;
import com.Model.User;

public class App {

	public static void main(String[] args) {
		System.out.println(org.hibernate.Version.getVersionString());
		
		SessionFactory sf = Connection.getInstance();
		Session session = sf.openSession();
		session.beginTransaction();
		User user = new User();
		user.setIdUser(222);
		user.setPassword("123456");
		user.setState((byte)1);
		user.setUserType("Cliente");
		
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
