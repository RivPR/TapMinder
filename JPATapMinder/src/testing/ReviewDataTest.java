package testing;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.BeerRating;
import entityData.UserTypeName;



public class ReviewDataTest {

	
	EntityManagerFactory emf;
	EntityManager em;

	BeerRating rating;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("tapminderdb");
		em = emf.createEntityManager();
		rating = em.find(BeerRating.class, 7);
		/*
		 * ****************************************
		 * REMEBER: the first rating has an id of 7
		 * at the time this test was created
		 * ****************************************
		 */
		
	}
	@Test
	public void userId(){
		assertEquals(1,rating.getUser().getId());
	}
	

	
	@Test
	public void beerId(){
		assertEquals(33,rating.getBeer().getId());
	}
	
	
	
	@Test
	public void rating(){
		assertEquals(1,rating.getRating());
	}
	
	
	
	@Test
	public void comments(){
		assertEquals("Had a light taste ",rating.getComments());
	}
	
	
	
	@Test
	public void userFirstname(){	}
	
	
	
	@After
	public void tearDown() {
		em.close();
		emf.close();

	}

}