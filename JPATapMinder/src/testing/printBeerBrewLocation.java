package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class printBeerBrewLocation {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		
		EntityManager em = emf.createEntityManager();

		//
		Beer b = em.find(Beer.class, 1)
		
		
		em.close();
		
		emf.close();
	}
	
}
