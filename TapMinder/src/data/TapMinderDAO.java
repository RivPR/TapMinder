package data;

import java.util.List;

import entities.Beer;
import entities.BeerRating;
import entities.Brewery;
import entities.Neighborhood;
import entities.User;
import entities.UserType;

public interface TapMinderDAO {

	//get beers
	
	
	//beers
	
	public Beer  getBeer(int beerId);
	
	public List<Beer> getBeers(BeerParameters beerParameters);
	
	public void modifyBeer(Beer beer);
	
	public void deleteBeer(Beer beer);
	public void deleteBeer(Integer beerId);

	public void addBeer(Beer beer);
	
	//breweries
	
	public Brewery getBrewery(int breweryId);
	
	public List<Brewery> getAllBreweries();
	
	public List<Brewery> getBreweries(BreweryParameters breweryParameters);
	
	public void modifyBrewery(Brewery brewery, Integer neighborHoodId);
	
	public void addBrewery(Brewery brewery, Integer neighborHoodId);
	
	public void deleteBrewery(Brewery brewery);
	
	public void deleteBrewery(Integer brewery);
	//user
	
	public User refreshUser(User u);
	
	public List<User> getUserList();

	public boolean emailExists(String email);
	
	public User getUser(int userId);
	
	public void addUser(User user);
	
	public void modifyUser(User user);
	
	public void deleteUser(User user);
	
	public void deleteUser(int userId);
	
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

	
	//userType
	
	public UserType getUserType(int id);
	
	public List<UserType> getUserTypes();

	BeerRating getRatingByID(int id);

	void addRating(BeerRating beerRating);

	public List<String> getStates();

	void deleteRating(Integer userId, Integer beerRatingId);

	public void refreshRatingList(Integer id);

	void modifyStatus(User user);
	
	
	
	
	
	
}
