package exampleDataStuff;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;
import entities.Brewery;

/*
 * GET ALL BEERS, DISPLAY THE BEER NAME,
 * DISPLAY THE BREWERY NAME,
 * DISPLAY THE NUMBER OF PEOPLE THAT RATED
 * THAT BEER
 */

public class AllBeersPerBrewery {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();

		List<Beer> beers = em.createQuery("SELECT b FROM Beer b", Beer.class).getResultList();

		for (Beer b : beers) {
			System.out.println("BEER NAME: " + b.getName() + "\tBREWERY NAME: " + b.getBrewery().getName()
					+ "\t# OF PEOPLE RATED: " + b.getRatings().size());
		}

		em.close();
		emf.close();

	}

}
