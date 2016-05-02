package testing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Beer;
import entities.BeerRating;
import entities.User;

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
		
		System.out.println("###########################\n This is hop count lower than:");
		
		lower = 30;
		query = ("SELECT b FROM Beer b WHERE (b.hopCount <= :high) ORDER BY hopCount DESC");
		beerList = em.createQuery(query, Beer.class).setParameter("high", lower).getResultList();
		for (Beer beer : beerList) {
			System.out.println(beer.getName() +" Style:"+ beer.getBeerStyle()+ " " +beer.getHopCount());
		}
		System.out.println("###########################\n This is hop count higher than:");
		
		higher = 51;
		query = ("SELECT b FROM Beer b WHERE (b.hopCount >= :low) ORDER BY hopCount DESC");
		beerList = em.createQuery(query, Beer.class).setParameter("low", higher).getResultList();
		for (Beer beer : beerList) {
			System.out.println(beer.getName() +" Style:"+ beer.getBeerStyle()+ " " +beer.getHopCount());
		}
		System.out.println("###########################\n This is userlist:");
		List<User> userList=em.createQuery("SELECT u FROM User u", User.class).getResultList();
		for (User user : userList) {
			System.out.println(user.getId() + " " + user.getFirstname() + " " + user.getUsertype() );
		}
		
		System.out.println("###########################\n This is single user:");
		int userId= 2;
		query = "SELECT u FROM User u WHERE u.id = :userId" ;
		User singleUser =em.createQuery(query, User.class).setParameter("userId", userId).getSingleResult();
		System.out.println(singleUser.getFirstname() + " " + singleUser.getId() + " "+singleUser.getEmail());
		
		System.out.println("###########################\n This is ratings userid:");
		
		 query = "SELECT u.ratings FROM User u  WHERE u.id = 3" ;
		
		 List<BeerRating> ratingList =em.createQuery(query, BeerRating.class).setParameter("userId", userId).getResultList();
		 for (BeerRating beerRating : ratingList) {
			System.out.println(beerRating.getComments() + beerRating.getUser() + beerRating.toString());
		}
		 
		 System.out.println("###########################\n This is user by name:");
			String nameInput = "Ale";
		    String name = nameInput.toLowerCase().trim();
			name = "%" + name + "%";
			userList = em.createQuery("SELECT u FROM User u WHERE u.firstname LIKE LOWER(:name) ", User.class)
					.setParameter("name", name.toLowerCase()).getResultList();
			for (BeerRating beerRating : ratingList) {
				System.out.println(beerRating);
			}
		 
		em.close();
		emf.close();
	}
}
