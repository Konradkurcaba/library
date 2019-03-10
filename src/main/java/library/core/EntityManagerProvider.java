package library.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	private static EntityManager entityManager;
	private static String PERSISTENCE_UNIT_NAME = "libraryDB";

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			entityManager = eMFactory.createEntityManager();
		}
		return entityManager;
	}
}
