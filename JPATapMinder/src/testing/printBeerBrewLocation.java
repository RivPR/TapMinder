package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;

public class printBeerBrewLocation {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		
		EntityManager em = emf.createEntityManager();

		//
		Beer b = em.find(Beer.class, 1);
		
		System.out.println(b.getName());
		System.out.println(b.getBrewery().getStreetAddress());
		
		em.close();
		
		emf.close();
		
		
	}
	
}
