package data;

import java.util.List;

import javax.xml.transform.Result;

import entities.Beer;
import entities.BeerRating;
import entities.Brewery;
import entities.Neighborhood;
import entities.User;

public interface TapMinderDAO {

	//get beers
	
	
	//beers
	
	public List<Beer> getBeers(BeerParameters beerParameters);
	
	public Result addBeer(Beer beer);
	
	public Result modifyBeer(Beer beer);
	
	public Result deleteBeer(Beer beer);

	//breweries
	
	public List<Brewery> getBreweries(BreweryParameters breweryParameters);
	
	public Result addBrewery(Brewery brewery);
	
	public Result modifyBrewery(Brewery brewery);
	
	public Result deleteBrewery(Brewery brewery);
	
	//user
	public List<User> getUserList();

	public User getUser(int userId);
	
	public Results addUser(User user);

	public Results modifyUser(User user);
	
	public Results deleteUser(User user);
	
	//ratings
	
	public List<BeerRating> getRatingsByUser(User user);
	
	public List<BeerRating> getRatingsByBeer(Beer beer);
	
	public List<BeerRating> getRatingsByBrewery(Brewery brewery);
	
	public Results addRating(BeerRating beerRating);
	
	public Results modifyRating(BeerRating beerRating);
	
	public Results deleteRating(BeerRating beerRating);
	
	//neighborhoods
	
	public List<Neighborhood> getNeighborhoods();

	
	
	
	
	
	
	
	
	
	
}
