package helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

	 public static SessionFactory sessionfactory;
	 
	 public static SessionFactory getFactory()
	 {
		if(sessionfactory == null) 
		    	sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return sessionfactory;
	 }
	 public void closeFactory() {
		 if(sessionfactory.isOpen())
			 sessionfactory.close();
	 }
}
