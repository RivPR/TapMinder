package testing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;

public class DAOGetBeerListByNameTestMain {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
	EntityManager em = emf.createEntityManager();
	
	String input = "ch";
	String query = "%" + input + "%";
	List<Beer> beerList = em.createQuery("SELECT b FROM Beer b WHERE b.name LIKE LOWER(:params) ",Beer.class).setParameter("param",query.toLowerCase()).getResultList();
	
	for (Beer beer : beerList) {
		System.out.println(beer.getName());
	}
	
	em.close();
	emf.close();
}
}
