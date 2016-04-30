package testing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Neighborhood;

public class AlexGetNeighborhoodsTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();
		
		List<Neighborhood> neighborhoods = em.createQuery("Select n from Neighborhood n",Neighborhood.class).getResultList();
		
		for (Neighborhood neighborhood : neighborhoods) {
			em.detach(neighborhood);
		}
		
		for (Neighborhood neighborhood : neighborhoods) {
			System.out.println(neighborhood.getName());
		}
		
		em.close();
		emf.close();
		
	}
	
}
