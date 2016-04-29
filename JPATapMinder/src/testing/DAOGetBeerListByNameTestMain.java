package testing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;
import entities.BeerRating;

public class DAOGetBeerListByNameTestMain {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
	EntityManager em = emf.createEntityManager();
	
//	String input = "ch";
//	String query = "%" + input + "%";
//	List<Beer> beerList = em.createQuery("SELECT b FROM Beer b WHERE b.name LIKE LOWER(:params) ",Beer.class).setParameter("param",query.toLowerCase()).getResultList();
//	
//	
	
	
	
	int ratingLow = 3;
	int ratingHigh = 4;
	
	//TODO Fix
	
	
	List<BeerRating> ratings = em.createQuery("SELECT r FROM BeerRating r WHERE r.rating <= :high",BeerRating.class).setParameter("high",ratingHigh).getResultList();
	Set<Beer> beerSet = new HashSet<>();

	for (BeerRating r : ratings) {
		beerSet.add(r.getBeer());
	}
	List<Beer> beerList = new ArrayList<>();
	beerList.addAll(beerSet);
	
	for (Beer beer : beerList) {
		System.out.println(beer.getName());
	}
//	return beerList;
	

	em.close();
	emf.close();
}
}