package com.Dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	
	public Object get(Class<?> model,Serializable id) { 
		Object obj = session.get(model,id);
		return obj;
	}
	
	public void close() {
		session.close();
	}
	
	public Session getSession() {
		return session;
	}
	
	public List<?> getAllData(Class<?> clas){
		return session.createCriteria(clas).list();
	}
	
	
}
