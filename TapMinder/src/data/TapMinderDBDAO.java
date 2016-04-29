package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Beer;


@Transactional
public class TapMinderDBDAO implements TapMinderDAO{
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Beer> getBeers(BeerParameters beerParameters){
		int param= beerParameters.getId();			
		List<Beer> beer ;
		beer= em.createQuery("SELECT bp FROM ");
		return beer;
		
	}
	
	
	
	
	
	
	

	}
	
}
