package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.transform.Result;

import org.springframework.transaction.annotation.Transactional;

import entities.Beer;
import entities.BeerRating;
import entities.Brewery;
import entities.Neighborhood;
import entities.User;


@Transactional
public class TapMinderDBDAO implements TapMinderDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Beer> getBeers(BeerParameters beerParameters){
		List<Beer> beerList = null;
		
		if(beerParameters.getName() != null){
			beerList = getBeerListByName(beerParameters);
		}
		else if(beerParameters.getAbvHigh() != null && beerParameters.getAbvLow() != null){
						//search for range
		}
		else if(beerParameters.getAbvLow() != null && beerParameters.getAbvHigh() == null){
			//search for higher abvsjdflksdaj than ^
		}
		else if(beerParameters.getAbvHigh() != null && beerParameters.getAbvLow() == null){
			//search for lower abv than ^
		}
		else if(beerParameters.getStyle() != null){
			//seach by style
		}
		else if(beerParameters.getRatingLow() != null && beerParameters.getRatingHigh() != null){
			//search rating range
			
		}
		else if(beerParameters.getRatingLow() != null && beerParameters.getRatingHigh() == null){
			//search above ^ range
			
		}
		else if(beerParameters.getRatingLow() == null && beerParameters.getRatingHigh() != null){
			//search below ^ range
			
		}
		else if(beerParameters.getHopCountLow() != null && beerParameters.getHopCountHigh() != null){
			//range
		}
		else if(beerParameters.getHopCountLow() == null && beerParameters.getHopCountHigh() != null){
			//above ^
		}
		else if(beerParameters.getHopCountLow() != null && beerParameters.getHopCountHigh() == null){
			//bewlow ^
		}

			
		
		return beerList;
		
	}
	
	private List<Beer> getBeerListByName(BeerParameters beerParameters){
		String name = beerParameters.getName().toLowerCase();
		System.out.println(name);
		String query = "SELECT b FROM Beer b";
		System.out.println(query);
//		List<Beer> beerList = em.createQuery(query,Beer.class).getResultList();
		Beer beer = em.find(Beer.class, 1);
		System.out.println(beer);
		System.out.println(beer.getName());

		em.detach(beer);
		return null;
	}
//	private List<Beer> getBeerListByABVRange(BeerParameters beerParameters){
//		
//	}
//	private List<Beer> getBeerListByABVAbove(BeerParameters beerParameters){
//		
//	}
//	private List<Beer> getBeerListByABVBelow(BeerParameters beerParameters){
//		
//	}
//	private List<Beer> getBeerListByStyle(BeerParameters beerParameters){
//		
//	}
//	private List<Beer> getBeerListByRatingRange(BeerParameters beerParameters){
//		
//	}
//	private List<Beer> getBeerListByRatingAbove(BeerParameters beerParameters){
//		
//	}
//	private List<Beer> getBeerListByRatingBelow(BeerParameters beerParameters){
//		
//	}
//	private List<Beer> getBeerListByHopCountRange(BeerParameters beerParameters){
//		
//	}



	@Override
	public Result addBeer(Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result modifyBeer(Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result deleteBeer(Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Brewery> getBreweries(BreweryParameters breweryParameters) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result addBrewery(Brewery brewery) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result modifyBrewery(Brewery brewery) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result deleteBrewery(Brewery brewery) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Results addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Results modifyUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Results deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BeerRating> getRatingsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BeerRating> getRatingsByBeer(Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BeerRating> getRatingsByBrewery(Brewery brewery) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Results addRating(BeerRating beerRating) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Results modifyRating(BeerRating beerRating) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Results deleteRating(BeerRating beerRating) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Neighborhood> getNeighborhoods() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	

	}
	

