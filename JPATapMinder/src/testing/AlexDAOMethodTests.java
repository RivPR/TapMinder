package testing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Brewery;
import entities.Neighborhood;
import entityData.State;

public class AlexDAOMethodTests {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();
		
		int neighborhoodId = em.find(Neighborhood.class, 2).getId();
		String query = "SELECT b FROM Brewery b WHERE b.neighborhood.id = :neighborhoodId";
		
		List<Brewery> breweryList = em.createQuery(query,Brewery.class).setParameter("neighborhoodId", neighborhoodId).getResultList();
		System.out.println(breweryList.size());
		for (Brewery brewery : breweryList) {
			System.out.println(brewery.getName() + " " + brewery.getStreetAddress());
		}
		
		em.close();
		emf.close();
		
	}
}
