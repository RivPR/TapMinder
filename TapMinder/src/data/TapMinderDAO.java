package data;

import java.util.List;

import entities.Beer;
import entities.BeerRating;
import entities.Brewery;
import entities.Neighborhood;
import entities.User;

public interface TapMinderDAO {

	//get beers
	
	
	//beers
	
	public List<Beer> getBeers(BeerParameters beerParameters);
	
	public ModifyResults addBeer(Beer beer);
	
	public ModifyResults modifyBeer(Beer beer);
	
	public ModifyResults deleteBeer(Beer beer);

	//breweries
	
	public List<Brewery> getBreweries(BreweryParameters breweryParameters);
	
	public ModifyResults addBrewery(Brewery brewery);
	
	public ModifyResults modifyBrewery(Brewery brewery);
	
	public ModifyResults deleteBrewery(Brewery brewery);
	
	//user
	public List<User> getUserList();

	public User getUser(int userId);
	
	public ModifyResults addUser(User user);

	public ModifyResults modifyUser(User user);
	
	public ModifyResults deleteUser(User user);
	
	public User getUserByEmail(User user);
	
	//ratings
	
	public List<BeerRating> getRatingsByUser(User user);
	
	public List<BeerRating> getRatingsByBeer(Beer beer);
	
	public List<BeerRating> getRatingsByBrewery(Brewery brewery);
	
	public ModifyResults addRating(BeerRating beerRating);
	
	public ModifyResults modifyRating(BeerRating beerRating);
	
	public ModifyResults deleteRating(BeerRating beerRating);
	
	//neighborhoods
	
	public List<Neighborhood> getNeighborhoods();

	
	
	
	
	
	
	
	
	
	
}
