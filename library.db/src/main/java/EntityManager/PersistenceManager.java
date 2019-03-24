package EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	public static String PERSISTENCE_UNIT_NAME = "libraryDB";
	public static EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

}
