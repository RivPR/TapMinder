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
		System.out.println("###########################\n This is lower than:");
		
		double lower = 4.5d;
		query = ("SELECT b FROM Beer b WHERE (b.abv <= :high) ORDER BY abv DESC");
		beerList = em.createQuery(query, Beer.class).setParameter("high", lower).getResultList();
		for (Beer beer : beerList) {
			System.out.println(beer.getName() +" Style:"+ beer.getBeerStyle()+ " " +beer.getAbv());
		}
		
		System.out.println("###########################\n This is hop count range:");
		low = 5;
		high = 30;
		query = ("SELECT b FROM Beer b WHERE (b.hopCount >= :low) AND (b.hopCount <= :high) ORDER BY hopCount DESC");
		beerList = em.createQuery(query, Beer.class).setParameter("low", low).setParameter("high", high).getResultList();

		for (Beer beer : beerList) {
			System.out.println(beer.getName() +" Style:"+ beer.getBeerStyle()+ " " +beer.getHopCount());
		}
		
		
		em.close();
		emf.close();
	}
}
