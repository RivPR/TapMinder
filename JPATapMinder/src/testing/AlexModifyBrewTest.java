package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Brewery;
import entities.Neighborhood;
import entityData.State;

public class AlexModifyBrewTest {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();
		
		Brewery b = em.find(Brewery.class, 13);
		
		
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
}
