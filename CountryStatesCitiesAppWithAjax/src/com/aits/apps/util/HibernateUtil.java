package com.aits.apps.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements Cloneable {
	private static SessionFactory sf = null;

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			Configuration cfg = new Configuration();
			cfg.configure("oracle.cfg.xml");
			synchronized (cfg) {
				if (sf == null) {
					sf = cfg.buildSessionFactory();
				}
			}
		}
		return sf;
	}
}
