package com.Model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Connection {
	public static SessionFactory sf = null;

	private Connection() {

	}

	public static SessionFactory getInstance() {
		if (sf == null) {
			Configuration cf = new Configuration();
			cf.configure();
			ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();
			sf = cf.buildSessionFactory(sr);
		}
		return sf;
	}

}
