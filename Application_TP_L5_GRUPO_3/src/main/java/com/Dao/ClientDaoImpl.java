package com.Dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Model.Client;
import com.Model.User;

public class ClientDaoImpl implements ClientDao {

	SessionHandler sHand = new SessionHandler();
	Session session;

	public Boolean insertClient(Client client) {
		sHand = new SessionHandler();

		try {
			sHand.save(client);
			sHand.commit();
			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean updateClient(Client client) {
		try {
			sHand.update(client);
			sHand.commit();
			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Client getClient(Integer id) {
		try {
			Client client = (Client) sHand.get(Client.class, id);
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
		@SuppressWarnings("unchecked")
		ArrayList<Client> client = (ArrayList<Client>) sHand.getAllData(Client.class);
		return client;
	}


	public Boolean emailExist(String email) {
		String hql = "From Client c where c.email = :email";
		Query query = sHand.getSession().createQuery(hql);
		if(query.setParameter("email", email).setMaxResults(1).list().size() == 1) {
			return true;
		}
		return false;
	}
  
  
	public Boolean deleteClient(int id) {
		session = sHand.getSession();
		String hql = "update Client c set c.state=0  where c.idClient= :id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", id);
		try {
			Boolean bool = query.executeUpdate() == 1 ? true : false;
			/*if (bool)
				sHand.commit();
			else
				sHand.rollback();*/
			return bool;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean deleteUser(int id) {
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

}
