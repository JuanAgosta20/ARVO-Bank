package com.Dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.City;
import com.Model.Countrie;
import com.Model.Province;

public class LocationDaoImpl implements LocationDao {
	
	

	public LocationDaoImpl() {
		super();
	}

	SessionHandler sHand;
	Session session;

	@SuppressWarnings("unchecked")
	public ArrayList<Countrie> getAllCountries() {
		sHand = new SessionHandler();
		return (ArrayList<Countrie>) sHand.getAllData(Countrie.class);
		/*
		 * session = sHand.getSession(); try { ArrayList<Countrie> list =
		 * (ArrayList<Countrie>) session.createCriteria(Countrie.class).list(); return
		 * list; } catch (Exception e) { e.printStackTrace(); return null; }
		 */

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Province> getAllProvinces() {
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "From provinces p order by p.name asc";
		Query query = (Query) session.createQuery(hql);
		try {
			return  (ArrayList<Province>) query.list();
		}catch (Exception e) {
			return null;
		}
	}

	public City getCity(String id) {
		sHand = new SessionHandler();
		return (City) sHand.get(City.class, id);
	}
	
	public City getCity(String name, int prov) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "From City c where c.name= :name and c.prov =: prov";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("prov", prov);
		try {
			return  (City) query.uniqueResult();
		}catch (Exception e) {
			return null;
		}
	}
	
	public Boolean saveCity(City city) {
		sHand = new SessionHandler();
		try{
			sHand.save(city);
			sHand.commit();
			return true;
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	public Province getProvince(Integer id) {
		sHand = new SessionHandler();
		return (Province) sHand.get(Province.class, id);
	}

	public Countrie getCoountry(Integer id) { 
		sHand = new SessionHandler();
		return (Countrie) sHand.get(Countrie.class, id);
	}
	
	public Countrie getCountrie(int id) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		return (Countrie)session.get(Countrie.class, id);
	}

	public Province getProvinceApi(int id) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "From provinces p where p.idProvinceApi =:id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", id);
		
		return (Province)query.uniqueResult();
	}

}
