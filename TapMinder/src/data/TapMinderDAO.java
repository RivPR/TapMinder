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
	
	public Beer  getBeer(int beerId);
	
	public List<Beer> getBeers(BeerParameters beerParameters);
	
	public void modifyBeer(Beer beer);
	
	public void deleteBeer(Beer beer);

	//breweries
	
	public Brewery getBrewery(int breweryId);
	
	public List<Brewery> getBreweries(BreweryParameters breweryParameters);
	
	public void modifyBrewery(Brewery brewery, Integer neighborHoodId);
	
	public void addBrewery(Brewery brewery, Integer neighborHoodId);
	
	public void deleteBrewery(Brewery brewery);
	
	public void deleteBrewery(Integer brewery);
	//user
	
	
	
	public List<User> getUserList();

	public User getUser(int userId);
	
	public void modifyUser(User user);
	
	public void deleteUser(User user);
	
	public LoginResult getUserByLoginCredentials(User user);
	
	public List<User> getUsers(User user);
	
	//TODO replace w ^
	public List<User> getUserByFirstName(String nameInput);
	
	//ratings
	
	public List<BeerRating> getRatingsByUser(User user);
	
	public List<BeerRating> getRatingsByBeer(Beer beer);
	
	public List<BeerRating> getRatingsByBrewery(Brewery brewery);
	
	public void modifyRating(BeerRating beerRating);
	
	public void deleteRating(BeerRating beerRating);
	
	//neighborhoods
	
	public List<Neighborhood> getNeighborhoods();
	
	public Neighborhood getNeighborhood(int id);

	
	
	
	
	
	
	
	
	
	
}
