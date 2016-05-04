package data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public Beer getBeer(int beerId){
		Beer b = em.find(Beer.class, beerId);
		return b;
	}
	
	public List<Beer> getBeers(BeerParameters beerParameters) {

		List<Beer> beerList = null;

		if (beerParameters.getName() != null) {
			beerList = getBeerListByName(beerParameters);
		} else if (beerParameters.getAbvHigh() != null && beerParameters.getAbvLow() != null) {
			beerList = getBeerListByABVRange(beerParameters);
		} else if (beerParameters.getAbvLow() != null && beerParameters.getAbvHigh() == null) {
			// search for higher abv than ^
			beerList = getBeerListByABVAbove(beerParameters);
		} else if (beerParameters.getAbvHigh() != null && beerParameters.getAbvLow() == null) {
			// search for lower abv than ^
			beerList = getBeerListByABVBelow(beerParameters);
		} else if (beerParameters.getStyle() != null) {
			beerList = getBeerListByStyle(beerParameters);
		} else if (beerParameters.getRatingLow() != null && beerParameters.getRatingHigh() != null) {
			beerList = getBeerListByRatingRange(beerParameters);

		} else if (beerParameters.getRatingLow() != null && beerParameters.getRatingHigh() == null) {
			beerList = getBeerListByRatingAbove(beerParameters);

		} else if (beerParameters.getRatingLow() == null && beerParameters.getRatingHigh() != null) {
			beerList = getBeerListByRatingBelow(beerParameters);

		} else if (beerParameters.getHopCountLow() != null && beerParameters.getHopCountHigh() != null) {
			// range
			beerList = getBeerListByHopCountRange(beerParameters);
		} else if (beerParameters.getHopCountLow() == null && beerParameters.getHopCountHigh() != null) {
			// above ^
			beerList = getBeerlistByHopCountLow(beerParameters);
		} else if (beerParameters.getHopCountLow() != null && beerParameters.getHopCountHigh() == null) {
			// below ^
			beerList = getBeerlistByHopCountHigh(beerParameters);
		}

		if (beerList != null && beerList.size() > 0) {
//			for (Beer beer : beerList) {
//				em.detach(beer);
//			}

		}

		return beerList;

	}

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

	@Override
	public void addBeer(Beer beer){
		
		
		em.persist(beer);
	}
	
	@Override
	public void modifyBeer(Beer beer) {
		Beer beerToModify = em.find(Beer.class, beer.getId());
		beerToModify.setName(beer.getName());
		beerToModify.setAbv(beer.getAbv());
		beerToModify.setHopCount(beer.getHopCount());
		beerToModify.setBeerStyle(beer.getBeerStyle());
		beerToModify.setDescription(beer.getDescription());
		beerToModify.setImageLink(beer.getImageLink());
		
	}

	@Override
	public void deleteBeer(Beer beer) {
		em.remove(beer);
	}
	
	
	@Override
	public void deleteBeer(Integer id) {
		
		em.remove(em.find(Beer.class, id));
	}
	
	

	@Override
	public Brewery getBrewery(int breweryId){
		Brewery b = em.find(Brewery.class, breweryId);
		
		return b;
	}
	
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
		// TODO: put this in the other things jk maybe useless
//		for (Brewery brewery : breweryList) {
//			em.detach(brewery);
//		}
		return breweryList;
	}

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

	@Override
	public void addBrewery(Brewery brewery, Integer neighborHoodId){
		brewery.setNeighborhood(em.find(Neighborhood.class, neighborHoodId));
		em.persist(brewery);
	}
	
	@Override
	public void modifyBrewery(Brewery brewery, Integer neighborHoodId) {
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
		breweryToChange.setNeighborhood(em.find(Neighborhood.class, neighborHoodId));
		System.out.println("modded brw: " + breweryToChange);
	}

	@Override
	public void deleteBrewery(Brewery brewery) {
		//FK fails
		//TODO null pointer
		System.out.println("DELETE THSI ONE : " + brewery.getId());
		Brewery b = em.find(Brewery.class, brewery.getId());
		System.out.println("BREW TO DELETE " + b.getId());
//		List<Beer> beers = em.createQuery("SELECT b FROM Beer b WHERE b.brewery.id = :bid",Beer.class).setParameter("bid", brewery.getId()).getResultList();
//		for (Beer beer : beers) {
//			this.deleteBeer(beer);
//		}
//		
		
		em.remove(b);

	}
	
	@Override
	public void deleteBrewery(Integer breweryId) {

		Brewery b = em.find(Brewery.class, breweryId);
		System.out.println("BREW TO DELETE " + b.getId());
		
		em.remove(b);
		
	}

	@Override
	public List<User> getUserList() {
		List<User> userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
		return userList;
	}

	@Override
	public User getUser(int userId) {

		String query = "SELECT u FROM User u WHERE u.id = :userId";
		User userList = em.createQuery(query, User.class).setParameter("userId", userId).getSingleResult();
		return userList;
	}

	@Override
	public List<User> getUsers(User user){
		//search by first, last, email
		if(user.getFirstname() == null || user.getFirstname().length() < 1){
			user.setFirstname("");
		}
		
		if(user.getLastname() == null || user.getLastname().length() < 1){
			user.setLastname("");
		}
		
		if(user.getEmail() == null || user.getEmail().length() < 1){
			user.setEmail("");
		}
		String fname = "%" +  user.getFirstname() + "%";
		String lname = "%" +  user.getLastname() + "%";
		String email = "%" +  user.getEmail() + "%";
		
		String query = "SELECT u FROM User u WHERE"
				+ " u.firstname LIKE LOWER(:fname)"
				+ " AND u.lastname LIKE LOWER(:lname)"
				+ " AND u.email LIKE LOWER(:email)";
		List<User> users = em.createQuery(query,User.class)
				.setParameter("fname", fname.toLowerCase().trim())
				.setParameter("lname", lname.toLowerCase().trim())
				.setParameter("email", email.toLowerCase().trim())
				.getResultList();
//		
//		List<User> users = em.createQuery("SELECT u FROM User u",User.class).getResultList();
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

	@Override
	public LoginResult getUserByLoginCredentials(User userToLogin) {
		LoginResult lr = null;
		try {
			String query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
			User user = em.createQuery(query, User.class).setParameter("email", userToLogin.getEmail())
					.setParameter("password", userToLogin.getPassword()).getSingleResult();
			// TODO
			System.out.println("LOGGED IN USER " + user);
			lr = new LoginResult(user, "");
		} catch (NoResultException e) {
			lr = new LoginResult(null, "Incorrect Username Or Password");
		}

		return lr;
	}

	@Override
	public boolean emailExists(String email){
		try {
			String query = "SELECT u FROM User u WHERE u.email = :email";
			em.createQuery(query, User.class).setParameter("email", email).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
		
		
	}
	
	@Override
	public void addUser(User user){
		em.persist(user);
	}
	
	@Override
	public void modifyUser(User user) {
		User userToMod = em.find(User.class,user.getId());
		userToMod.setFirstname(user.getFirstname());
		userToMod.setLastname(user.getLastname());
		userToMod.setEmail(user.getEmail());
		userToMod.setPassword(user.getPassword());
		userToMod.setUsertype(user.getUsertype());
	}

	@Override
	public void deleteUser(int userId){
		em.remove(em.find(User.class, userId));
	}
	
	@Override
	public void deleteUser(User user) {
		int userID = user.getId();
		
		User userToDelete = em.find(User.class, userID);
		
		em.remove(userToDelete);
	}

	@Override
	public List<BeerRating> getRatingsByUser(User user) {

		List<BeerRating> ratingList = user.getRatings();

		return ratingList;
	}

	@Override
	public List<BeerRating> getRatingsByBeer(Beer beer) {
		// TODO untested

		List<BeerRating> ratingList = beer.getRatings();

		return ratingList;
	}

	@Override
	public List<BeerRating> getRatingsByBrewery(Brewery brewery) {
		List<Beer> beerList = brewery.getBeerList();

		List<BeerRating> ratingList = new ArrayList<>();

		for (Beer beer : beerList) {
			ratingList.addAll(beer.getRatings());
		}

		return ratingList;
	}

	@Override
	public void addRating(BeerRating beerRating) {
		List<BeerRating> BeerRating = em.createQuery("Select br from BeerRating br", BeerRating.class).getResultList();
		int counter = 0;
		for (BeerRating br : BeerRating) {
			if(br.getUser().getId()==beerRating.getUser().getId() && br.getBeer().getId()==beerRating.getBeer().getId()){
				counter++;
			}
			else{
				continue;
			}
		}
		System.out.println(counter);
		if(counter==0){
		em.persist(beerRating);
		}
	}
	
	@Override
	public void modifyRating(BeerRating br){
		BeerRating beerR =  em.find(BeerRating.class, br.getId());
		beerR.setRating(br.getRating());
		beerR.setComments(br.getComments());
		
	}

	@Override
	public void deleteRating(BeerRating beerRating) {
		em.remove(beerRating);
	}

	
	@Override
	public Neighborhood getNeighborhood(int id){
		return em.find(Neighborhood.class, id);
	}
	
	@Override
	public List<Neighborhood> getNeighborhoods() {

		List<Neighborhood> neighborhoods = em.createQuery("Select n from Neighborhood n", Neighborhood.class)
				.getResultList();
		System.out.println("THE STUPID NEIGHBORHOOD LIST IS " + neighborhoods.size() +" THINGIES LONG");
		for (Neighborhood neighborhood : neighborhoods) {
			em.detach(neighborhood);
		}

		return neighborhoods;

	}
	

	@Override
	public User refreshUser(User u){
		u =  em.merge(u);
		em.refresh(u);
		return u;
	}

	 
	@Override
	public UserType getUserType(int id){
		return em.find(UserType.class, id);
		
	}
	
	@Override 
	public List<UserType> getUserTypes(){
		
		List<UserType> userTypeList = new ArrayList<>();
		
		userTypeList.add(em.find(UserType.class, 1));
		userTypeList.add(em.find(UserType.class, 2));
		userTypeList.add(em.find(UserType.class, 3));

		
		return userTypeList;
	}
	
	@Override
	public BeerRating getRatingByID(int id){
		BeerRating br = new BeerRating();
		br= em.find(BeerRating.class, id);
		return br;
	}


}
