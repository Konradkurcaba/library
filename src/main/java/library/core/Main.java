package library.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.jandex.TypeTarget.Usage;

import library.entities.User;

public class Main {

	
	public static void main(String...aArgs)
	{
		EntityManagerFactory Emfactory = Persistence.createEntityManagerFactory("libraryDB");
		EntityManager entityManger = Emfactory.createEntityManager();
		
		User user = new User();
		user.setFirstName("Stefan");
		
		
		entityManger.getTransaction().begin();
		entityManger.persist(user);
		entityManger.getTransaction().commit();
		
		user.setLastName("Malina");
		
		entityManger.getTransaction().begin();
		entityManger.getTransaction().commit();
	}
	
	
}

