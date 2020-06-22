package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.Client;
import com.Model.Connection;

public class SessionHandler {
	SessionFactory sessionFact = Connection.getInstance();
	Session session;
	
	public SessionHandler() {
		session = sessionFact.openSession();
		session.beginTransaction();
	}
	
	public void commit() {
		session.getTransaction().commit();
	}
	
	public void rollback() {
		session.getTransaction().rollback();
	}
	
	public void save(Object object) {
		session.save(object);
	}
	
	public void update(Object object) {
		session.update(object);
	}
	
	public void delete(Object object) {
		session.delete(object);
	}
	
	public void merge(Object object) {
		session.merge(object);
	}
	
	public Client get(Integer id) {
		Client client = (Client)session.get("Clients",id);
		return client;
	}
	
	public void close() {
		sessionFact.close();
	}
	
	public Session getSession() {
		return session;
	}
	
	
}
