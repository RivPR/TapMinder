package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Beer;
import entities.BeerRating;
import entities.Brewery;
import entities.Neighborhood;
import entities.User;
import entities.UserType;
import entityData.State;

@Transactional
public class TapMinderDBDAO implements TapMinderDAO {

	@PersistenceContext
	private EntityManager em;

	// get beer by id
	public Beer getBeer(int beerId) {
		Beer b = em.find(Beer.class, beerId);
		return b;
	}

	// get beer by beerParameters
	public List<Beer> getBeers(BeerParameters beerParameters) {

		List<Beer> beerList = null;
		// get by name
		if (beerParameters.getName() != null) {
			beerList = getBeerListByName(beerParameters);
		}
		// get by abv range
		else if (beerParameters.getAbvHigh() != null && beerParameters.getAbvLow() != null) {
			beerList = getBeerListByABVRange(beerParameters);
		}
		// get by abv above
		else if (beerParameters.getAbvLow() != null && beerParameters.getAbvHigh() == null) {
			// search for higher abv than ^
			beerList = getBeerListByABVAbove(beerParameters);
		}
		// get by abv below
		else if (beerParameters.getAbvHigh() != null && beerParameters.getAbvLow() == null) {
			// search for lower abv than ^
			beerList = getBeerListByABVBelow(beerParameters);
		}
		// get by style
		else if (beerParameters.getStyle() != null) {
			beerList = getBeerListByStyle(beerParameters);
		}
		// get by rating range
		else if (beerParameters.getRatingLow() != null && beerParameters.getRatingHigh() != null) {
			beerList = getBeerListByRatingRange(beerParameters);

		}
		// get by ratings above..
		else if (beerParameters.getRatingLow() != null && beerParameters.getRatingHigh() == null) {
			beerList = getBeerListByRatingAbove(beerParameters);

		}
		// get by ratings below
		else if (beerParameters.getRatingLow() == null && beerParameters.getRatingHigh() != null) {
			beerList = getBeerListByRatingBelow(beerParameters);

		}
		// get by hopcount range
		else if (beerParameters.getHopCountLow() != null && beerParameters.getHopCountHigh() != null) {
			beerList = getBeerListByHopCountRange(beerParameters);
		}
		// get by hopcount above
		else if (beerParameters.getHopCountLow() == null && beerParameters.getHopCountHigh() != null) {
			beerList = getBeerlistByHopCountLow(beerParameters);
		}
		// get by hopcount below
		else if (beerParameters.getHopCountLow() != null && beerParameters.getHopCountHigh() == null) {
			beerList = getBeerlistByHopCountHigh(beerParameters);
		}

		return beerList;

	}
	/*
	 * ******************************************************** The following
	 * methods get a list of beers in a similary way.
	 * 
	 * The methods with strings append % to both sides of the string and perform
	 * a query with "LIKE" and LOWER on a search parameter string changed to
	 * lowercase. This allows queries on partial strings and mixed cases.
	 * 
	 * The numeric queries use boolean (greater than, less than, equal to)
	 * operators *******************************************************
	 */

	/*
	 * START GET BEER METHODS
	 */

	private List<Beer> getBeerListByName(BeerParameters beerParameters) {

		String name = beerParameters.getName().trim();

		name = "%" + name + "%";
		List<Beer> beerList = em.createQuery("SELECT b FROM Beer b WHERE b.name LIKE LOWER(:name) ", Beer.class)
				.setParameter("name", name.toLowerCase()).getResultList();

		return beerList;
	}

	private List<Beer> getBeerListByABVRange(BeerParameters beerParameters) {
		double low = beerParameters.getAbvLow();
		double high = beerParameters.getAbvHigh();

		String query = ("SELECT b FROM Beer b WHERE (b.abv >= :low) AND (b.abv <= :high) ORDER BY abv DESC");
		List<Beer> beerList = em.createQuery(query, Beer.class).setParameter("low", low).setParameter("high", high)
				.getResultList();

		return beerList;
	}

	private List<Beer> getBeerListByABVAbove(BeerParameters beerParameters) {
		double higher = beerParameters.getAbvLow();
		String query = ("SELECT b FROM Beer b WHERE (b.abv >= :low) ORDER BY abv ASC");
		List<Beer> beerList = em.createQuery(query, Beer.class).setParameter("low", higher).getResultList();
		return beerList;

	}

	private List<Beer> getBeerListByABVBelow(BeerParameters beerParameters) {
		double lower = beerParameters.getAbvHigh();
		String query = ("SELECT b FROM Beer b WHERE (b.abv <= :high) ORDER BY abv DESC");
		List<Beer> beerList = em.createQuery(query, Beer.class).setParameter("high", lower).getResultList();
		return beerList;
	}

	private List<Beer> getBeerListByStyle(BeerParameters beerParameters) {
		String style = beerParameters.getStyle().trim();
		style = "%" + style + "%";
		List<Beer> beerList = em.createQuery("SELECT b FROM Beer b WHERE b.beerStyle LIKE LOWER(:style) ", Beer.class)
				.setParameter("style", style.toLowerCase()).getResultList();

		return beerList;
	}

	private List<Beer> getBeerListByRatingRange(BeerParameters beerParameters) {
		int ratingHigh = beerParameters.getRatingHigh();
		int ratingLow = beerParameters.getRatingLow();

		List<Beer> list1 = new ArrayList<>();
		List<Beer> listOBeer = em.createQuery("SELECT b FROM Beer b ORDER BY b.name ASC", Beer.class).getResultList();
		for (Beer beer : listOBeer) {
			if (beer.getAverageRating() <= ratingHigh && beer.getAverageRating() >= ratingLow) {
				list1.add(beer);
			}
		}
		return list1;

	}

	private List<Beer> getBeerListByRatingAbove(BeerParameters beerParameters) {
		int ratingLow = beerParameters.getRatingLow();

		List<Beer> list1 = new ArrayList<>();
		List<Beer> listOBeer = em.createQuery("SELECT b FROM Beer b ORDER BY b.name ASC", Beer.class).getResultList();
		for (Beer beer : listOBeer) {
			if (beer.getAverageRating() >= ratingLow) {
				list1.add(beer);
			}
		}
		return list1;
	}

	private List<Beer> getBeerListByRatingBelow(BeerParameters beerParameters) {
		int ratingHigh = beerParameters.getRatingHigh();

		List<Beer> list1 = new ArrayList<>();
		List<Beer> listOBeer = em.createQuery("SELECT b FROM Beer b ORDER BY b.name ASC", Beer.class).getResultList();
		for (Beer beer : listOBeer) {
			if (beer.getAverageRating() <= ratingHigh) {
				list1.add(beer);
			}
		}
		return list1;
	}

	private List<Beer> getBeerListByHopCountRange(BeerParameters beerParameters) {
		double low = beerParameters.getHopCountLow();
		double high = beerParameters.getHopCountHigh();

		String query = ("SELECT b FROM Beer b WHERE (b.hopCount >= :low) AND (b.hopCount <= :high) ORDER BY hopCount DESC");
		List<Beer> beerList = em.createQuery(query, Beer.class).setParameter("low", low).setParameter("high", high)
				.getResultList();

		return beerList;
	}

	private List<Beer> getBeerlistByHopCountLow(BeerParameters beerParameters) {
		double lower = beerParameters.getHopCountHigh();
		String query = ("SELECT b FROM Beer b WHERE (b.hopCount <= :high) ORDER BY hopCount DESC");
		List<Beer> beerList = em.createQuery(query, Beer.class).setParameter("high", lower).getResultList();

		return beerList;
	}

	private List<Beer> getBeerlistByHopCountHigh(BeerParameters beerParameters) {
		double higher = beerParameters.getHopCountLow();
		String query = ("SELECT b FROM Beer b WHERE (b.hopCount >= :low) ORDER BY hopCount DESC");
		List<Beer> beerList = em.createQuery(query, Beer.class).setParameter("low", higher).getResultList();
		return beerList;
	}

	/*
	 * END GET BEER METHODS
	 */

	// add beer
	@Override
	public void addBeer(Beer beer) {

		em.persist(beer);
	}

	// modify beer
	@Override
	public void modifyBeer(Beer beer) {
		// get a beer entity and call setters on it to modify its values
		Beer beerToModify = em.find(Beer.class, beer.getId());

		beerToModify.setName(beer.getName());
		beerToModify.setAbv(beer.getAbv());
		beerToModify.setHopCount(beer.getHopCount());
		beerToModify.setBeerStyle(beer.getBeerStyle());
		beerToModify.setDescription(beer.getDescription());
		beerToModify.setImageLink(beer.getImageLink());

	}

	// remove beer by ojbect
	@Override
	public void deleteBeer(Beer beer) {
		em.remove(beer);
	}

	// remove beer by id
	@Override
	public void deleteBeer(Integer id) {
		Beer beerToDelete = em.find(Beer.class, id);
		// TODO i think it doesn't work with blank breweries
		List<BeerRating> ratings = beerToDelete.getRatings();
		// remove ratings associated with beer
		for (BeerRating beerRating : ratings) {
			em.remove(beerRating);
		}
		// remove from database
		em.remove(beerToDelete);

	}

	// get brewery by id
	@Override
	public Brewery getBrewery(int breweryId) {
		Brewery b = em.find(Brewery.class, breweryId);

		return b;
	}

	// get a list of all breweries
	@Override
	public List<Brewery> getAllBreweries() {
		return em.createQuery("SELECT b FROM Brewery b", Brewery.class).getResultList();
	}

	// get a list of brewery by parameters
	@Override
	public List<Brewery> getBreweries(BreweryParameters breweryParameters) {
		List<Brewery> breweryList = null;
		if (breweryParameters.getName() != null) {
			breweryList = getBreweryListByName(breweryParameters);
		} else if (breweryParameters.getStreetAddress() != null) {
			breweryList = getBreweryListByStreetAddress(breweryParameters);
		} else if (breweryParameters.getCity() != null) {
			breweryList = getBreweryListByCity(breweryParameters);
		} else if (breweryParameters.getState() != null) {
			breweryList = getBreweryListByState(breweryParameters);
		} else if (breweryParameters.getZipcode() != null) {
			breweryList = getBreweryListByZipcode(breweryParameters);
		} else if (breweryParameters.getNeighborhood() != null) {
			breweryList = getBreweryListByNeighborhood(breweryParameters);
		}

		return breweryList;
	}

	/*
	 * THESE METHODS ARE SIMILAR TO TEH GET BEER METHODS EARLIER IN THIS DAO
	 * FILE
	 * 
	 * 
	 * START GET BREWERY
	 */

	private List<Brewery> getBreweryListByName(BreweryParameters breweryParameters) {
		String name = "%" + breweryParameters.getName() + "%";
		String query = "SELECT b FROM Brewery b WHERE LOWER(b.name) LIKE :name";

		List<Brewery> breweryList = em.createQuery(query, Brewery.class).setParameter("name", name.toLowerCase())
				.getResultList();
		return breweryList;

	}

	private List<Brewery> getBreweryListByStreetAddress(BreweryParameters breweryParameters) {
		String streetAddress = "%" + breweryParameters.getStreetAddress() + "%";
		String query = "SELECT b FROM Brewery b WHERE LOWER(b.streetAddress) LIKE :streetAddress";

		List<Brewery> breweryList = em.createQuery(query, Brewery.class)
				.setParameter("streetAddress", streetAddress.toLowerCase()).getResultList();
		return breweryList;
	}

	private List<Brewery> getBreweryListByCity(BreweryParameters breweryParameters) {
		String city = "%" + breweryParameters.getCity() + "%";
		String query = "SELECT b FROM Brewery b WHERE LOWER(b.city) LIKE :city";

		List<Brewery> breweryList = em.createQuery(query, Brewery.class).setParameter("city", city.toLowerCase())
				.getResultList();
		return breweryList;
	}

	private List<Brewery> getBreweryListByState(BreweryParameters breweryParameters) {
		State state = breweryParameters.getState();
		String query = "SELECT b FROM Brewery b WHERE b.state =  :state";

		List<Brewery> breweryList = em.createQuery(query, Brewery.class).setParameter("state", state).getResultList();
		return breweryList;
	}

	private List<Brewery> getBreweryListByZipcode(BreweryParameters breweryParameters) {
		Integer zip = 80226;
		String query = "SELECT b FROM Brewery b WHERE b.zip = :zip";

		List<Brewery> breweryList = em.createQuery(query, Brewery.class).setParameter("zip", zip).getResultList();

		return breweryList;

	}

	private List<Brewery> getBreweryListByNeighborhood(BreweryParameters breweryParameters) {
		int neighborhoodId = breweryParameters.getNeighborhood().getId();
		String query = "SELECT b FROM Brewery b WHERE b.neighborhood.id = :neighborhoodId";

		List<Brewery> breweryList = em.createQuery(query, Brewery.class).setParameter("neighborhoodId", neighborhoodId)
				.getResultList();
		return breweryList;
	}

	/*
	 * END GET BREWWERY
	 */

	// add a brewery
	@Override
	public void addBrewery(Brewery brewery, Integer neighborHoodId) {
		// set neighborhood and add
		brewery.setNeighborhood(em.find(Neighborhood.class, neighborHoodId));
		em.persist(brewery);
	}

	// modify brewery
	@Override
	public void modifyBrewery(Brewery brewery, Integer neighborHoodId) {
		// get a brewery object, and use setters to update
		int breweryId = brewery.getId();
		Brewery breweryToChange = em.find(Brewery.class, breweryId);
		System.out.println("modding brwery: " + breweryToChange);
		breweryToChange.setName(brewery.getName());
		breweryToChange.setStreetAddress(brewery.getStreetAddress());
		breweryToChange.setCity(brewery.getCity());
		breweryToChange.setState(brewery.getState());
		breweryToChange.setZip(brewery.getZip());
		breweryToChange.setImageLink(brewery.getImageLink());
		breweryToChange.setBreweryLink(brewery.getBreweryLink());
		// find neighborhood based on id and set new neighborhood
		breweryToChange.setNeighborhood(em.find(Neighborhood.class, neighborHoodId));
		System.out.println("modded brw: " + breweryToChange);
	}

	// remove brewery
	@Override
	public void deleteBrewery(Brewery brewery) {
		// get a brewery entity
		Brewery breweryToDelete = em.find(Brewery.class, brewery.getId());

		List<Beer> ratings = breweryToDelete.getBeerList();
		//remove all beers associated with the brewery
		for (Beer beer : ratings) {
			System.out.println(em.contains(beer));
			deleteBeer(beer.getId());
		}
		//delete brewery
		em.remove(breweryToDelete);
		System.out.println("DELETED");

	}

	//get a list of states by iterating over the enum values
	@Override
	public List<String> getStates() {
		List<String> stateList = new ArrayList<>();

		for (State s : State.values()) {
			stateList.add(s.toString());
		}

		return stateList;

	}

	@Override
	//delete a brewery by id
	public void deleteBrewery(Integer breweryId) {
		//get a brewery
		Brewery breweryToDelete = em.find(Brewery.class, breweryId);
		//get a list of beers from teh brewery
		List<Beer> beers = breweryToDelete.getBeerList();
		//delete each beer for the brewery to avoid
		//foreign key errors
		for (Beer beer : beers) {
			System.out.println(em.contains(beer));
			deleteBeer(beer.getId());
		}
		//remove the brewery
		em.remove(breweryToDelete);
		System.out.println("DELETED");

	}

	//get a list of users
	@Override
	public List<User> getUserList() {
		List<User> userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
		return userList;
	}

	//get a single user by id
	@Override
	public User getUser(int userId) {

		String query = "SELECT u FROM User u WHERE u.id = :userId";
		User userList = em.createQuery(query, User.class).setParameter("userId", userId).getSingleResult();
		return userList;
	}

	//get users by parameters
	@Override
	public List<User> getUsers(User user) {
		// search by first, last, email, if not set, set to blank, or "")
		if (user.getFirstname() == null || user.getFirstname().length() < 1) {
			user.setFirstname("");
		}

		if (user.getLastname() == null || user.getLastname().length() < 1) {
			user.setLastname("");
		}

		if (user.getEmail() == null || user.getEmail().length() < 1) {
			user.setEmail("");
		}
		
//		create a query
		String fname = "%" + user.getFirstname() + "%";
		String lname = "%" + user.getLastname() + "%";
		String email = "%" + user.getEmail() + "%";

		String query = "SELECT u FROM User u WHERE" + " u.firstname LIKE LOWER(:fname)"
				+ " AND u.lastname LIKE LOWER(:lname)" + " AND u.email LIKE LOWER(:email)";
		List<User> users = em.createQuery(query, User.class).setParameter("fname", fname.toLowerCase().trim())
				.setParameter("lname", lname.toLowerCase().trim()).setParameter("email", email.toLowerCase().trim())
				.getResultList();
		//
		// List<User> users = em.createQuery("SELECT u FROM User
		// u",User.class).getResultList();
		System.out.println("IN GET USERS DAO METHOD");
		for (User user2 : users) {
			System.out.println(user2.getFirstname());
		}

		return users;

	}

	@Override
	public List<User> getUserByFirstName(String nameInput) {
		String name = nameInput.toLowerCase().trim();
		name = "%" + name + "%";
		List<User> userList = em.createQuery("SELECT u FROM User u WHERE u.firstname LIKE LOWER(:name) ", User.class)
				.setParameter("name", name.toLowerCase()).getResultList();
		return userList;
	}

	
	//get a login result (user / error message)
	@Override
	public LoginResult getUserByLoginCredentials(User userToLogin) {
		LoginResult lr = null;
		try {
			//select the email and password form the user passed in, and query users that match
			//password is case sensitive
			String query = "SELECT u FROM User u WHERE LOWER(u.email) = :email AND u.password = :password";
			User user = em.createQuery(query, User.class).setParameter("email", userToLogin.getEmail().toLowerCase().trim())
					.setParameter("password", userToLogin.getPassword()).getSingleResult();
			// TODO changed lower thing
			//if there is a result, add user and blank error message
			lr = new LoginResult(user, "");
		} catch (NoResultException e) {
			//if there is no result, add an error message
			lr = new LoginResult(null, "Incorrect Username Or Password");
		}

		return lr;
	}

//	check if email exists in database
	@Override
	public boolean emailExists(String email) {
		try {
			String query = "SELECT u FROM User u WHERE u.email = :email";
			em.createQuery(query, User.class).setParameter("email", email).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}

	}

	
	//add a user by user object
	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	
	//modify user
	@Override
	public void modifyUser(User user) {
		//get user to modify
		User userToMod = em.find(User.class, user.getId());
		//call setters to update user in database (auto commits)
		userToMod.setFirstname(user.getFirstname());
		userToMod.setLastname(user.getLastname());
		userToMod.setEmail(user.getEmail());
		userToMod.setPassword(user.getPassword());
		userToMod.setUsertype(user.getUsertype());
	}

	
	//delete user
	@Override
	public void deleteUser(int userId) {
		User userToDelete = em.find(User.class, userId);

		//get all beer ratings associated with the user
		List<BeerRating> ratings = userToDelete.getRatings();
		//delete the beer ratings (avoids foreign key errors)
		for (BeerRating beerRating : ratings) {
			System.out.println(em.contains(beerRating));
			em.remove(beerRating);
		}
		//remove user
		em.remove(userToDelete);
		System.out.println("DELETED");

	}

	//delete user by user object (delete by userId method works better)
	@Override
	public void deleteUser(User user) {
		int userID = user.getId();

		User userToDelete = em.find(User.class, userID);

		em.remove(userToDelete);
	}

//	get beer ratings by user
	
	@Override
	public List<BeerRating> getRatingsByUser(User user) {

		List<BeerRating> ratingList = user.getRatings();

		return ratingList;
	}

	//get beer ratings by beer
	
	@Override
	public List<BeerRating> getRatingsByBeer(Beer beer) {
		// TODO untested

		List<BeerRating> ratingList = beer.getRatings();

		return ratingList;
	}

	//get beer ratings by brewery
	
	@Override
	public List<BeerRating> getRatingsByBrewery(Brewery brewery) {
		List<Beer> beerList = brewery.getBeerList();

		List<BeerRating> ratingList = new ArrayList<>();

		for (Beer beer : beerList) {
			ratingList.addAll(beer.getRatings());
		}

		return ratingList;
	}

	//add a beer rating
	
	@Override
	public void addRating(BeerRating beerRating) {
		List<BeerRating> BeerRating = em.createQuery("Select br from BeerRating br", BeerRating.class).getResultList();
		int counter = 0;
		for (BeerRating br : BeerRating) {
			if (br.getUser().getId() == beerRating.getUser().getId()
					&& br.getBeer().getId() == beerRating.getBeer().getId()) {
				counter++;
			} else {
				continue;
			}
		}
		if (counter == 0) {
			em.persist(beerRating);
		}
	}

	
	//modify a beer rating
	@Override
	public void modifyRating(BeerRating br) {
		//select rating by id
		BeerRating beerR = em.find(BeerRating.class, br.getId());
		//update rating and comments for beer ratings
		beerR.setRating(br.getRating());
		beerR.setComments(br.getComments());

	}

	//delete rating by object (by ids works better)
	@Override
	public void deleteRating(BeerRating beerRating) {
		em.remove(beerRating);
	}

	
	//delete ratings
	@Override
	public void deleteRating(Integer userId, Integer ratingId) {
		//get user that is deleting ratings
		User user = em.find(User.class, userId);
		//get ratings for user
		List<BeerRating> ratings = user.getRatings();

		// get the rating to delete
		BeerRating br = em.find(BeerRating.class, ratingId);
		em.merge(br);
		em.remove(br);
		
		// remove from rating user list
		ratings.remove(em.find(BeerRating.class, ratingId));
		//reset user rating list
		user.setRatings(ratings);
		/*
		 * SOME OF THIS MAY SEEM UNECESSARY, BUT THE USER'S RATING LIST
		 * WOULD NOT UPDATE UNTIL LOGGED OUT SO I HAD TO TAKE
		 * EXTRA MEASURES TO ENSURE THAT THE USER'S RATINGS WERE
		 * UPDATED
		 */
	}

	
	//get neighborhood by id
	@Override
	public Neighborhood getNeighborhood(int id) {
		return em.find(Neighborhood.class, id);
	}

	//get all neighborhoods in a list
	@Override
	public List<Neighborhood> getNeighborhoods() {

		List<Neighborhood> neighborhoods = em.createQuery("Select n from Neighborhood n", Neighborhood.class)
				.getResultList();
		for (Neighborhood neighborhood : neighborhoods) {
			em.detach(neighborhood);
		}

		return neighborhoods;

	}

	@Override
	public User refreshUser(User u) {
		u = em.merge(u);
		em.refresh(u);
		return u;
	}

	@Override
	public void refreshRatingList(Integer id) {
		User u = em.merge(em.find(User.class, id));
		em.refresh(u);

	}

	//get user type (admin, moderator, or standard)
	@Override
	public UserType getUserType(int id) {
		return em.find(UserType.class, id);

	}

	//get all possible user types
	@Override
	public List<UserType> getUserTypes() {

		List<UserType> userTypeList = new ArrayList<>();

		userTypeList.add(em.find(UserType.class, 1));
		userTypeList.add(em.find(UserType.class, 2));
		userTypeList.add(em.find(UserType.class, 3));

		return userTypeList;
	}

	//get a beer rating by its id
	
	@Override
	public BeerRating getRatingByID(int id) {
		BeerRating br = new BeerRating();
		br = em.find(BeerRating.class, id);
		return br;
	}

}
