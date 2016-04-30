package testing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Brewery;

public class AlexDAOMethodTests {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();
		
		String streetAddress = "%kala%";
		String query = "SELECT b FROM Brewery b WHERE LOWER(b.streetAddress) LIKE :name";
		
		List<Brewery> breweryList = em.createQuery(query,Brewery.class).setParameter("name", streetAddress.toLowerCase()).getResultList();
		System.out.println(breweryList.size());
		for (Brewery brewery : breweryList) {
			System.out.println(brewery.getName() + " " + brewery.getStreetAddress());
		}
		
		em.close();
		emf.close();
		
	}
}
