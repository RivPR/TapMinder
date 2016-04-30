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
		b.setName("BREWPLACE modded");
		b.setStreetAddress("123 fake modded");
		b.setCity("Denver");
		b.setNeighborhood(em.find(Neighborhood.class,3));
		b.setState(State.CO);
		b.setZip(12345);
		
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
}
