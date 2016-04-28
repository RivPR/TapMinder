package testing;

import static org.junit.Assert.fail;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JPATest {

	@Before
	public void setup() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tapminderdb");
		EntityManager em = emf.createEntityManager();
	}

	@Test
	public void testBeerName() {
		assertEquals(1, 1);

	}

	@After
	public void teardown() {

	}

};