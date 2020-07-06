package com.Dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class Paginator {
	SessionHandler shand = new SessionHandler();
	
	public ArrayList<?> Paginate(Class<?> classs, Integer take, Integer skip, Integer filterType){
		Criteria criteria = shand.getSession().createCriteria(classs);
		switch(filterType){
		case 1:
				criteria.add(Restrictions.like("lastName", "%Rodr%"));
			break;
		case 2: 
				criteria.add(Restrictions.eq("state",(byte) 1));
			break;
		default:
			break;
		}
		
		criteria.setFirstResult(skip);
		criteria.setMaxResults(take);
		
		return (ArrayList<?>) criteria.list();
	}
	
	public Integer getTotal(Class<?> classs) {
		return shand.getAllData(classs).size();
	}
	
	public Integer getTotalPages(Class<?> classs,Integer cantPerPage, Integer filterType) {
		Criteria criteria = shand.getSession().createCriteria(classs);
		switch(filterType){
		case 1:
				criteria.add(Restrictions.like("lastName", "%Rodr%"));
			break;
		case 2: 
				criteria.add(Restrictions.eq("state",(byte) 1));
			break;
		default:
			break;
		}
		Integer pages = criteria.list().size() /cantPerPage;
		if(pages % cantPerPage != 0 || pages == 0)
			pages = pages + 1;
		return pages;
		
	}
	
	public Integer actualPage(){
		return 0;
	}
	
}
