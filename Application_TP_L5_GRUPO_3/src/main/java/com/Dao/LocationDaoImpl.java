package com.Dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Countrie;
import com.Model.Province;

public class LocationDaoImpl implements LocationDao {
	
	

	public LocationDaoImpl() {
		super();
	}

	SessionHandler sHand = new SessionHandler();
	Session session;

	@SuppressWarnings("unchecked")
	public ArrayList<Countrie> getAllCountries() {

		return (ArrayList<Countrie>) sHand.getAllData(Countrie.class);
		/*
		 * session = sHand.getSession(); try { ArrayList<Countrie> list =
		 * (ArrayList<Countrie>) session.createCriteria(Countrie.class).list(); return
		 * list; } catch (Exception e) { e.printStackTrace(); return null; }
		 */

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Province> getAllProvinces() {
		session = sHand.getSession();
		String hql = "From provinces p order by p.name asc";
		Query query = (Query) session.createQuery(hql);
		try {
			return  (ArrayList<Province>) query.list();
		}catch (Exception e) {
			return null;
		}
	}

	public Countrie getCountrie(int id) {
		session = sHand.getSession();
		return (Countrie)session.get(Countrie.class, id);
	}

	public Province getProvince(int id) {
		session = sHand.getSession();
		String hql = "From provinces p where p.idProvinceApi =:id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", id);
		
		return (Province)query.uniqueResult();
	}

}
