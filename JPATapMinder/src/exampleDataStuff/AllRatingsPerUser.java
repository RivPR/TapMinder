package exampleDataStuff;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.BeerRating;
import entities.User;

public class AllRatingsPerUser {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
	EntityManager em = emf.createEntityManager();
	
	List<User> users = em.createQuery("SELECT u FROM User u",User.class).getResultList();
	
	for (User user : users) {
		System.out.println(user.getFirstname() + ":");
		for (BeerRating r : user.getRatings()) {
			System.out.println("\tBEER:" + r.getBeer().getName());
			System.out.println("\tRATING:" + r.getRating());
			System.out.println("\tCOMMENTS:" + r.getComments());
		}
	}
	
	
	
	
	em.close();
	emf.close();
}
}
