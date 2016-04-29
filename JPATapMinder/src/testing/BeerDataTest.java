package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Beer;
import entityData.State;

import static org.junit.Assert.*;

public class BeerDataTest {

	EntityManagerFactory emf;
	EntityManager em;

	Beer beer;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("tapminderdb");
		em = emf.createEntityManager();
		beer = em.find(Beer.class, 1);
		
	}

	@Test
	public void beerName() {
		String name = beer.getName();
		assertEquals("Avalanche Ale",name);
	}

	@Test
	public void beerAbv() {
		Double abv = 4.4;
		assertEquals(beer.getAbv(),abv);

	}
	
	@Test
	public void beerHopCount() {
		Double hops = 2.5;
		assertEquals(hops,beer.getHopCount());
	}
	
	@Test
	public void beerStyle() {
		assertEquals("Ale",beer.getBeerStyle());
	}
	
	@Test
	public void beerDescription() {
		assertEquals("Nice beer",beer.getDescription());
	}
	
	@Test
	public void beerImageLink() {
		assertEquals("",beer.getImageLink()); //NO IMAGE LINK FOR BEER # 1
	}
	
	@Test
	public void beerBreweryName() {
		assertEquals("Breckenridge Brewery",beer.getBrewery().getName());
	}
	
	@Test
	public void beerStreetAddress() {
		assertEquals("471 Kalamath St.",beer.getBrewery().getStreetAddress());
	}
	
	@Test
	public void beerCity() {
		assertEquals("Denver",beer.getBrewery().getCity());
	}
	
	@Test
	public void beerState() {
		assertEquals(State.CO,beer.getBrewery().getState());
	}
	
	@Test
	public void beerZip() {
		assertEquals(80204,beer.getBrewery().getZip());
	}


	@Test
	public void beerBreweryImageLink() {
		assertEquals("http://www.breckbrew.com/_stay_out/images/logo.png",beer.getBrewery().getImageLink());
		}
	
	@Test
	public void beerBreweryLink() {
		assertEquals("http://www.breckbrew.com/",beer.getBrewery().getBreweryLink());
	}
	
	@Test
	public void beerNeighborhoodName() {
		assertEquals("Littleton",beer.getBrewery().getNeighborhood().getName());
	}
	

	@After
	public void tearDown() {
		em.close();
		emf.close();

	}

}
