package testing;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Beer;

public class AngelJUnit {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("tapminderdb");
		em = emf.createEntityManager();
	}


	@Test
	public void test1() {
		Beer b = em.find(Beer.class, 1);
		assertEquals(1, b.getId());
		assertEquals("Avalanche Ale", b.getName());

	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
}
