package com.Dao;

import java.util.ArrayList;

import org.hibernate.Criteria;

public class Paginator {
	SessionHandler shand = new SessionHandler();
	
	public ArrayList<?> Paginate(Class<?> classs, Integer take, Integer skip){
		Criteria criteria = shand.getSession().createCriteria(classs);
		criteria.setFirstResult(skip);
		criteria.setMaxResults(take);
		
		return (ArrayList<?>) criteria.list();
	}
	
	public Integer getTotal(Class<?> classs) {
		return shand.getAllData(classs).size();
	}
	
	public Integer getTotalPages(Class<?> classs,Integer cantPerPage) {
		Integer total = getTotal(classs);
		Integer pages = total / cantPerPage;
		if(pages % cantPerPage != 0)
			pages = pages + 1;
		return pages;
	}
	
	public Integer actualPage(){
		return 0;
	}
	
}
