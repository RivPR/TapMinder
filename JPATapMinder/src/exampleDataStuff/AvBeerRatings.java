package exampleDataStuff;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;
import entities.BeerRating;
import entities.Brewery;

/*
 * GET ALL BEERS, DISPLAY THE BEER NAME,
 * DISPLAY THE BREWERY NAME,
 * DISPLAY THE AVERAGE RATING
 */

public class AvBeerRatings {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();

		List<Beer> beers = em.createQuery("SELECT b FROM Beer b", Beer.class).getResultList();

		for (Beer b : beers) {
			int rateCount = b.getRatings().size();
			int rateSum = 0;
			int rateAvg = 0;
			for (BeerRating br : b.getRatings()) {
				rateSum += br.getRating();
			}
			
			if(rateCount != 0){
				rateAvg = (rateSum/rateCount);
			}
			
			System.out.println("BEER NAME: " + b.getName() + "\tBREWERY NAME: " + b.getBrewery().getName()
					+ "\tAVERAGE RATING: " + rateAvg);
		}

		em.close();
		emf.close();

	}

}
