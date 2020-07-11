package com.Dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Client;
import com.Model.User;

public class ClientDaoImpl implements ClientDao {

	SessionHandler sHand;
	Session session;

	public void destroy() {
		sHand.close();
	}

	public Boolean insertClient(Client client) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		try {
			session.save(client);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
			session.close();
			return false;
		}
	}

	public Boolean updateClient(Client client) {
		sHand = new SessionHandler();
		try {
			sHand.update(client);
			sHand.commit();
			sHand.close();
			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Client getClient(Integer id) {
		sHand = new SessionHandler();
		try {
			Client client = (Client) sHand.get(Client.class, id);
			sHand.close();
			return client;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Client getClient(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client getClient(User user) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		Client client;
		try {
			client = (Client) session.get(Client.class, user.getIdUser().intValue());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return client;
	}

	public ArrayList<Client> getClients() {
		sHand = new SessionHandler();
		@SuppressWarnings("unchecked")
		ArrayList<Client> client = (ArrayList<Client>) sHand.getAllData(Client.class);
		return client;
	}


	public Boolean emailExist(String email) {
		sHand = new SessionHandler();
		String hql = "From Client c where c.email = :email";
		Query query = sHand.getSession().createQuery(hql);
		if(query.setParameter("email", email).setMaxResults(1).list().size() == 1) {
			return true;
		}
		return false;
	}
  
  
	public Boolean deleteClient(int id) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "update Client c set c.state=0  where c.idClient= :id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", id);
		try {
			Boolean bool = query.executeUpdate() == 1 ? true : false;
			if (bool)
				sHand.commit();
			else
				sHand.rollback();
			return bool;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean deleteUser(int id) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "update User u set  u.state=0 where u.idUser= :id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", id);
		try {
			Boolean bool = query.executeUpdate() == 1 ? true : false;
			if (bool)
				sHand.commit();
			else
				sHand.rollback();
			return bool;
		} catch (Exception e) {
			return false;
		}
	}

	public Client getClientByUserId(User user) {
		Client cli;
		sHand = new SessionHandler();
		session = sHand.getSession();
		int id = user.getIdUser();
		String hql = "From Client c WHERE c.user.idUser = :id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", id);
		try {
			cli = (Client) query.uniqueResult();
			return cli;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Boolean dniExist(String dni) {
		sHand = new SessionHandler();
		String hql = "From Client c where c.dni = :dni";
		Query query = sHand.getSession().createQuery(hql);
		if(query.setParameter("dni", dni).setMaxResults(1).list().size() == 1) {
			return true;
		}
		return false;
	}

}
