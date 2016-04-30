package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Brewery;
import entities.Neighborhood;
import entityData.State;

public class AlexPersistBrewTest {

public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();

		Brewery b = new Brewery();
		b.setName("BREWPLACE");
		b.setStreetAddress("123 fake");
		b.setCity("Denver");
		b.setNeighborhood(em.find(Neighborhood.class,2));
		b.setState(State.CO);
		b.setZip(12345);
		
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	
}
