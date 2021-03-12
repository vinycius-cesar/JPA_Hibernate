package posjavamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil{
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {
	   
		try {
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();//prove a parte de persistencia
	}
	
	public static Object getPrimariKey(Object entity) {// Retorna a primary key
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}