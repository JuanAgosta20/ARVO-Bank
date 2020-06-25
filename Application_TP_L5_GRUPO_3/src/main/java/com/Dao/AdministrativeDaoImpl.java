package com.Dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Administrative;
import com.Model.User;

public class AdministrativeDaoImpl implements AdministrativeDao {

	SessionHandler sHand = new SessionHandler();
	Session session;

	public Administrative getAdministrative(User user) {

		Administrative adm;
		session = sHand.getSession();
		int id = user.getIdUser();
		String hql = "From Administrative a WHERE a.user.idUser = :id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", id);
		try {
			adm = (Administrative) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//session.close();
		return adm;
	}

	/*
	 * session = sHand.getSession(); Administrative admin; try { admin =
	 * (Administrative) session.get(Administrative.class,
	 * user.getIdUser().intValue()); }catch (Exception e) { e.printStackTrace();
	 * return null; }finally { session.close(); } return admin; }
	 */

}
