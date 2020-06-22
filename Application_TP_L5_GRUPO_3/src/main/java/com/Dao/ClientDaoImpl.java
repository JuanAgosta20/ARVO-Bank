package com.Dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.Model.Client;
import com.Model.Connection;

public class ClientDaoImpl implements ClientDao {

	SessionFactory sFactory = Connection.getInstance();
	SessionHandler sHand; 

	
	public Boolean insertClient(Client client) {
		sHand = new SessionHandler();

		try {
			sHand.save(client);
			sHand.commit();
			return true;
		}catch(HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean updateClient(Client client) {
		try {
			sHand.update(client);
			sHand.commit();
			return true;
		}catch(HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Client getClient(Integer id) {
		try {
			Client client = sHand.get(id);
			return client;
		}catch(HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Client getClient(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
