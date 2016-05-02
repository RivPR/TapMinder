package testing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;
import entities.BeerRating;
import entities.Brewery;

public class AlexResultTestStuff {

		public static void main(String[] args) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
			
			EntityManager em = emf.createEntityManager();
			//get rates by user
			
			Brewery b = em.find(Brewery.class, 2);
			
			List<Beer> beerList = brewery.getBeerList();
			
			List<BeerRating> ratingList = new ArrayList<>();
			
			for (Beer beer : beerList) {
				ratingList.addAll(beer.getRatings());
			}
			
			
			for (BeerRating beerRating : ratingList) {
				System.out.println(beerRating.getComments());
			}
			
			em.close();
			
			emf.close();
			
		}
}
