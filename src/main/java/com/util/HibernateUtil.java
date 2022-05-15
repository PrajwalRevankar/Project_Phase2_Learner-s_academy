package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory buildSessionfactory()
	{
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		return sessionfactory;
	}

}
