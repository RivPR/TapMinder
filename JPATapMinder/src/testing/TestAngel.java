package testing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;

public class TestAngel {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();
		double low = 8;
		double high = 10;

		String query = ("SELECT b FROM Beer b WHERE (b.abv >= :low) AND (b.abv <= :high) ORDER BY abv DESC");
		List<Beer> beerList = em.createQuery(query, Beer.class).setParameter("low", low).setParameter("high", high)
				.getResultList();

		for (Beer beer : beerList) {
			System.out.println(beer.getName() +" Style:"+ beer.getBeerStyle()+ " " +beer.getAbv());
		}
		
		double higher = 7;
		query = ("SELECT b FROM Beer b WHERE (b.abv >= :low) ORDER BY abv ASC");
		beerList = em.createQuery(query, Beer.class).setParameter("low", higher).getResultList();
		System.out.println("Higher than: 7");
		for (Beer beer : beerList) {
			System.out.println(beer.getName() +" Style:"+ beer.getBeerStyle()+ " " +beer.getAbv());
		}
		
		
		
		
		em.close();
		emf.close();
	}
}
