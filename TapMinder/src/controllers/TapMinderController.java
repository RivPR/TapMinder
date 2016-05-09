package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.BeerParameters;
import data.BreweryParameters;
import data.LoginResult;
import data.TapMinderDAO;
import entities.Beer;
import entities.BeerRating;
import entities.Brewery;
import entities.User;

/*
 * I just made this to test out the stuff we learned in class
 */
@Controller
@SessionAttributes({ "currentUser" })
public class TapMinderController {

	@ModelAttribute("currentUser")
	private User setBlankCurrentUser() {
		User user = new User();
		return user;
	}

	@Autowired
	private TapMinderDAO dao;

	// initilizes the page when the user goes to tapminder
	@RequestMapping(path = "initPage.do", method = RequestMethod.GET)
	public ModelAndView initializeLogin(@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentUser", currentUser);
		mv.addObject("user", new User());
		mv.setViewName("index.jsp");
		return mv;

	}

	// this runs after login
	@RequestMapping(path = "initPage.do", method = RequestMethod.POST)
	public ModelAndView initializeLoginAndIndex(User user, @ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		// Login result returns a user or an error message
		LoginResult result = dao.getUserByLoginCredentials(user);

		// if the result returns a user, log them in and go to the main page
		if (result.getUser() != null) {
			mv.addObject("currentUser", result.getUser());
			mv.setViewName("mainPage.jsp");
		}
		// if the result returns an error message, pass that to the jsp instead
		// and return to the index page
		else {
			mv.addObject("LoginError", result.getMessage());
			mv.addObject("user", new User());
			mv.setViewName("initPage.do");
		}
		return mv;
	}
	/*method to send back to portfolio website */
	@RequestMapping( path= "menu.do", params="linkout" )
	private ModelAndView sendBackToPortfolio(){
		return new ModelAndView("redirect:" + "http://www.armoreira.com");
	}
	
	@RequestMapping("menu.do")
	private ModelAndView menu(@RequestParam("menuChoice") String menuChoice,
			@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();

		// menu actions mapped below
		switch (menuChoice) {

		case "findBeers":
			mv.addObject("searchSetting", "");
			mv.setViewName("searchBeer.jsp");
			break;

		// finds beers, initializes brewery search setting and go to the brewery
		// search page
		case "findBreweries":
			mv.addObject("searchSetting", "");
			mv.setViewName("searchBreweries.jsp");
			break;
		// view the users beers
		case "viewUserBeers":
			mv.setViewName("findUserBeerList.do");
			break;
		// view the users's own account
		case "myAccount":
			mv.setViewName("viewUserAccount.do");
			break;
		// modify other users (for admin only, access level 3)
		case "modifyUsers":
			if (currentUser.getUsertype().getAccessLevel() > 2) {
				// add a blank user object
				mv.addObject("User", new User());
				// add current user object so the header can see it and display
				// the users name
				mv.addObject("currentUser", currentUser);
				mv.setViewName("manageUsers.jsp");
			}
			// if not access level 3 somehow, go back to the main page
			else {
				mv.setViewName("mainPage.jsp");
			}
			break;
		// add a new user (not sign up, add another person, admin only)
		case "addUser":
			// add a blank user object and go to the add page
			if (currentUser.getUsertype().getAccessLevel() > 2) {
				mv.addObject("User", new User());
				mv.setViewName("addUser.jsp");

			}
			// if not admin, go back to main page
			else {
				mv.setViewName("mainPage.jsp");
			}
			break;
		// add a brewery (moderator and admin only)
		case "addBreweries":
			// add a new brewery (and neighborhood list) and go to the add
			// brewery page
			if (currentUser.getUsertype().getAccessLevel() > 1) {
				mv.addObject("Brewery", new Brewery());
				mv.addObject("neighborhoodList", dao.getNeighborhoods());

				mv.setViewName("addBrewery.jsp");
			}
			// if not admin, go back to main page
			else {
				mv.setViewName("mainPage.jsp");
			}
			break;
		// sign up( self sign up)
		case "signUp":
			mv.addObject("User", new User());
			mv.setViewName("signUp.jsp");
			break;
		// lougout the user
		case "logout":
			// set the currentUser session attribute to a blank user
			// (defaults to access level zero, so it allows us
			// to restrict some features to login only (loggin
			// in as any type of user gives an access level of
			// at least one).
			currentUser = new User();
			mv.addObject("currentUser", currentUser);
			mv.addObject("user", new User());
			mv.setViewName("index.jsp");
			break;
		default:
			// catch anything else and redirect it to the login / index page
			mv.setViewName("index.jsp");
			break;

		}

		return mv;

	}// end menu.do

	// prepare the add beer page
	// this is called from a button by a brewery search result
	// to add beers to a brewery
	@RequestMapping("addBeerPage.do")
	private ModelAndView addBeerPage(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("breweryId") Integer breweryId) {

		ModelAndView mv = new ModelAndView();
		// if the user is logged in and wants to add a beer:
		if (currentUser.getUsertype().getAccessLevel() > 0) {
			// get the brewery by id, and get a new beer object
			// go to beer adding page
			mv.addObject("Brewery", dao.getBrewery(breweryId));
			mv.addObject("Beer", new Beer());
			mv.setViewName("addBeer.jsp");
		} else {


			mv.setViewName("initPage.do");
		}
		return mv;

	}

	// setup modifying the beer page
	@RequestMapping("modifyBeerPage.do")
	private ModelAndView modifyBeerPage(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("beerId") Integer beerId) {

		ModelAndView mv = new ModelAndView();
		// if the user is logged in:
		if (currentUser.getUsertype().getAccessLevel() > 0) {
			// add a beer to modify and go to the modify page
			mv.addObject("Beer", dao.getBeer(beerId));

			mv.setViewName("modifyBeer.jsp");
		} else {
			// if not logged in go back to the main page
			mv.setViewName("initPage.do");
		}
		return mv;

	}

	// add a beer
	@RequestMapping("addBeer.do")
	private ModelAndView addBeer(@ModelAttribute("Beer") @Valid Beer beer, Errors errors,
			@RequestParam("breweryId") Integer breweryId, @ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		// if there were no errors in the form....
		if (errors.getErrorCount() == 0) {
			// make sure the user is logged in
			if (currentUser.getUsertype().getAccessLevel() > 0) {
				// set the beers brewery
				beer.setBrewery(dao.getBrewery(breweryId));
				// add the beer using the dao method
				dao.addBeer(beer);
			}
			// go back to the main page
			mv.addObject("Beer", new Beer());
			mv.setViewName("mainPage.jsp");
		} else {
			// if logged in...
			if (currentUser.getUsertype().getAccessLevel() > 0) {
				// get brewery
				mv.addObject("Brewery", dao.getBrewery(breweryId));
				// add error message
				mv.addObject("aerrorMessage", "There was a syntax error in your parameters, try again.");
				// return to add beer page, to try again
				mv.setViewName("addBeer.jsp");
			} else {

				mv.setViewName("index.jsp");
			}

		}
		return mv;
	}

	// modify a beer
	@RequestMapping("modifyBeer.do")
	private ModelAndView modifyBeer(@ModelAttribute("currentUser") User currentUser, Beer beer) {
		ModelAndView mv = new ModelAndView();
		// if the user is logged in submit the beer to the dao modification
		// method and return the the main page
		if (currentUser.getUsertype().getAccessLevel() > 0) {
			dao.modifyBeer(beer);
		}

		mv.setViewName("mainPage.jsp");
		return mv;
	}

	// delete a beer
	@RequestMapping("deleteBeer.do")
	private ModelAndView deleteBeer(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("beerId") Integer beerId) {
		ModelAndView mv = new ModelAndView();
		// if the current user is logged in, send the beer id to the delete
		// method in the dao
		if (currentUser.getUsertype().getAccessLevel() > 0) {
			dao.deleteBeer(beerId);
		}

		mv.setViewName("mainPage.jsp");
		return mv;

	}

	// modify brewery page setup
	@RequestMapping("modifyBreweryPage.do")
	private ModelAndView modifyBrewery(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("breweryId") Integer breweryId) {
		ModelAndView mv = new ModelAndView();
		// if the user is a moderator or admin (level 2 or 3)
		if (currentUser.getUsertype().getAccessLevel() > 1) {
			// get the brewery to modify, by id
			Brewery brewery = dao.getBrewery(breweryId);
			// add the objects necessary to add a beer
			mv.addObject("Brewery", brewery);
			// not really needed since it is automatic for now,
			// since the app is currently limited to colorado
			mv.addObject("stateEnumList", dao.getStates());
			mv.addObject("neighborhoodList", dao.getNeighborhoods());
			// go to the modify page
			mv.setViewName("modifyBrewery.jsp");

		}
		// if not logged in go back to the login page
		else {
			mv.setViewName("initPage.do");
		}
		return mv;
	}

	// modify a brewery
	@RequestMapping("modifyBrewery.do")
	private ModelAndView changeBrewery(@ModelAttribute("Brewery") @Valid Brewery brewery, Errors errors,
			@RequestParam("neighboorHoodId") Integer neighborHoodId) {
		ModelAndView mv = new ModelAndView();
		// if there are no errors...
		if (errors.getErrorCount() == 0) {
			// submit the brewery along with its neighborhood to the modify
			// brewery method in the dao, then return to the search page
			dao.modifyBrewery(brewery, neighborHoodId);
			mv.addObject("Brewery", brewery);
			mv.addObject("searchSetting", "");
			mv.setViewName("searchBreweries.jsp");
		}
		// if there are errors...
		else {
			// add the brewery and neighborhood list, and return to
			// the modify page to try again
			mv.addObject("Brewery", brewery);
			mv.addObject("neighborhoodList", dao.getNeighborhoods());
			mv.setViewName("modifyBrewery.jsp");

		}

		return mv;
	}

	// remove a brewery
	@RequestMapping("deleteBrewery.do")
	private ModelAndView deleteBrewery(@RequestParam("breweryId") Integer breweryId) {
		ModelAndView mv = new ModelAndView();
		// pass brewery id to delete brewery method in the dao, then return to
		// the main page
		dao.deleteBrewery(breweryId);
		mv.setViewName("mainPage.jsp");
		return mv;
	}

	// add a brewery
	@RequestMapping("addBrewery.do")
	private ModelAndView addBrewery(@ModelAttribute("Brewery") @Valid Brewery brewery, Errors errors,
			@RequestParam("neighboorHoodId") Integer neighborHoodId) {
		ModelAndView mv = new ModelAndView();
		// if there are no errors...
		if (errors.getErrorCount() == 0) {
			// add a brewery with the add brewery method
			// in the dao (required neighborhood id, it is
			// difficult to pass a neighborhood from the jsp)
			dao.addBrewery(brewery, neighborHoodId);
			mv.addObject("Brewery", brewery);
			mv.addObject("searchSetting", "");
			mv.setViewName("searchBreweries.jsp");

		} else {
			// if there are errors, return to the add a brewery page
			mv.addObject("neighborhoodList", dao.getNeighborhoods());
			mv.setViewName("addBrewery.jsp");
		}
		return mv;
	}

	// view the users own account
	@RequestMapping("viewUserAccount.do")
	private ModelAndView viewUserAccount(@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		// add the current user and go to the account page
		mv.addObject("currentUser", currentUser);
		mv.setViewName("userAccount.jsp");

		return mv;
	}

	// get and pass the user's rated beers to the jsp
	@RequestMapping("findUserBeerList.do")
	private ModelAndView printUserBeers(@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		//
		User userLogged = null;

		// re attach current user....
		/*
		 * I had several problems with trying to go back to the myBeers page
		 * after deleting a beer rating, and the only solution i could get to
		 * work reliably is setting the current user to null, and then
		 * reassigning it to the current user by the user id.
		 */
		if (currentUser.getId() > 0) {
			int userId = currentUser.getId();
			currentUser = null;
			currentUser = dao.getUser(userId);

		}

		// get the current user
		userLogged = dao.getUser(currentUser.getId());
		// get the user's ratings
		List<BeerRating> userRatings = userLogged.getRatings();

		List<Beer> beers = new ArrayList<>();
		// assign a beer to the beer list when the user has a rating for that
		// beer
		if (userRatings != null && userRatings.size() > 0) {
			for (BeerRating beerRating : userRatings) {
				beers.add(beerRating.getBeer());
			}
		}
		// assign objects and go the user's beer page
		mv.addObject("ratings", userRatings);
		mv.addObject("userBeers", beers);
		mv.addObject("currentUser", currentUser);
		mv.setViewName("myBeers.jsp");

		return mv;
	}

	// set up find beer page
	@RequestMapping("findBeersPage.do")
	private ModelAndView findBeers(@RequestParam("findBy") String choice) {

		ModelAndView mv = new ModelAndView();
		// 'choice' is the parameter that the user
		// wishes to search by
		// pass all relevant stuff to the jsp, and
		// go to the search page
		mv.addObject("searchSetting", choice);
		mv.addObject("Breweries", dao.getAllBreweries());
		mv.addObject("BeerParameters", new BeerParameters());
		mv.setViewName("searchBeer.jsp");

		return mv;
	}

	@RequestMapping("searchBeers.do")
	private ModelAndView searchBeers(@ModelAttribute("currentUser") User currentUser,
			@ModelAttribute("BeerParameters") @Valid BeerParameters beerParameters, Errors errors,
			@RequestParam("breweryId") Integer breweryId) {
		ModelAndView mv = new ModelAndView();
		List<Beer> beerList;
		// if there are no errors....
		if (errors.getErrorCount() == 0) {
			if (breweryId != null && breweryId > 0) {
				// if it was searched by brewery, add it to the beer list
				beerList = dao.getBrewery(breweryId).getBeerList();
			} else {
				// if it was not added by brewery, go to the getBeers method in
				// the
				// dao and get the beer list
				beerList = dao.getBeers(beerParameters);

			}
			mv.addObject("beerList", beerList);
			mv.addObject("currentUser", currentUser);
			mv.setViewName("searchResult.jsp");
		} else {
			// if there were errors, reset the search setting and go back to the
			// search setup page
			mv.addObject("errorMessage", "Please enter valid search critera.");
			mv.addObject("searchSetting", "");
			mv.addObject("Breweries", dao.getAllBreweries());
			mv.addObject("BeerParameters", new BeerParameters());
			mv.setViewName("searchBeer.jsp");

		}
		return mv;
	}

	// setup search breweries page
	@RequestMapping("searchBreweriesPage.do")
	private ModelAndView searchBreweriesPage(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("findBy") String choice) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stateEnumList", dao.getStates());
		mv.addObject("BreweryParameters", new BreweryParameters());
		mv.addObject("currentUser", currentUser);
		mv.addObject("neighborhoodList", dao.getNeighborhoods());
		mv.addObject("searchSetting", choice);
		mv.setViewName("searchBreweries.jsp");

		return mv;

	}

	// search for breweries
	@RequestMapping("searchBreweries.do")
	private ModelAndView searchBreweries(@ModelAttribute("currentUser") User currentUser,
			@ModelAttribute("BreweryParameters") @Valid BreweryParameters breweryParameters, Errors errors,
			Integer neighboorHoodId) {
		ModelAndView mv = new ModelAndView();
		// if there aren't any errors
		if (errors.getErrorCount() == 0) {
			if (neighboorHoodId != null) {
				// set the neighborhood
				breweryParameters.setNeighborhood(dao.getNeighborhood(neighboorHoodId));
			}
			// get brewery list from the dao
			List<Brewery> breweryList = dao.getBreweries(breweryParameters);
			mv.addObject("breweryList", breweryList);
			// an if statement in the jsp needs this to display something
			// if the search is empty. this object is necessary because
			// it allows the jsp to test if the searchSubmitted was true,
			// and can display a message if the search was submitted and
			// there are no results.
			mv.addObject("searchSubmitted", true);
			mv.setViewName("searchBreweries.jsp");

		} else {
			// if the search parameters are invalid, try again
			mv.addObject("errorMessage", "Please enter valid search parameters.");
			mv.addObject("BreweryParameters", new BreweryParameters());
			mv.addObject("currentUser", currentUser);
			mv.addObject("neighborhoodList", dao.getNeighborhoods());
			mv.addObject("searchSetting", "");
			mv.setViewName("searchBreweries.jsp");
		}
		return mv;
	}

	// search for users (admin only)
	@RequestMapping("findUsers.do")
	private ModelAndView findUsers(@ModelAttribute("currentUser") User currentUser, User user) {
		ModelAndView mv = new ModelAndView();
		// if user is admin
		if (currentUser.getUsertype().getAccessLevel() > 2) {
			// get the user list based on the parameters passed in (user)
			List<User> userList = dao.getUsers(user);
			// go to list of matching users
			mv.addObject("User", user);
			mv.addObject("userList", userList);
			mv.setViewName("manageUsers.jsp");

		}
		// go back to the main page if not admin
		else {
			mv.setViewName("mainPage.jsp");
		}
		// reset the current user. this was a remedy for an odd problem -
		// the user logged in would become the user that was searched for...
		Integer currentUserId = currentUser.getId();
		currentUser = null;
		currentUser = dao.getUser(currentUserId);
		mv.addObject("currentUser", currentUser);
		return mv;
	}

	// add a new user (not self sign up)
	@RequestMapping("addUser.do")
	private ModelAndView addUser(@ModelAttribute("User") @Valid User user, Errors errors, Integer userTypeId) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() == 0) {
			// get the user type of the new user
			user.setUsertype(dao.getUserType(userTypeId));
			// add user using dao method
			dao.addUser(user);
			// go back to manager users
			mv.addObject("User", user);
			mv.setViewName("manageUsers.jsp");
		} else {
			// go back to addUser page
			mv.addObject("User", user);
			mv.setViewName("addUser.jsp");

		}

		return mv;
	}

	// sign up (self sign up)
	@RequestMapping("signUp.do")
	private ModelAndView signUp(@ModelAttribute("User") @Valid User user, Errors errors) {
		ModelAndView mv = new ModelAndView();
		// **if a user signs up, they can only be a standard user unless edited
		// by the admin**
		if (errors.getErrorCount() == 0) {
			// check if the email exsists
			// if email doesn't already exist:
			if (!dao.emailExists(user.getEmail())) {
				// set the user type to standard (1)
				user.setUsertype(dao.getUserType(1));
				// add the suer
				dao.addUser(user);
				// go back to the sign in page, and autopopulate the users
				// username and password
				mv.addObject("User", user);
				// ***index.jsp uses a lowercase u user by accident,
				// so i needed to user a lwoercase one here as well.
				mv.addObject("user", user);
				mv.setViewName("index.jsp");
			} else {
				// if the email is in use, error message and try again.
				mv.addObject("User", user);
				mv.addObject("errorMessage", "That email is already in use.");
				mv.setViewName("signUp.jsp");
			}

		} else {
			// if there is a form error, error message and try again
			mv.addObject("errorMessage", "There was a syntax error in the form.");
			mv.addObject("User", user);
			mv.setViewName("signUp.jsp");

		}
		return mv;
	}

	// setup modify user page
	@RequestMapping("modifyUserPage.do")
	private ModelAndView modifiyUserPage(@RequestParam("userId") Integer userId) {
		ModelAndView mv = new ModelAndView();
		// get the user by id from the dao
		mv.addObject("User", dao.getUser(userId));
		// get the user type list form the
		mv.addObject("userTypeList", dao.getUserTypes());
		// go to modify page
		mv.setViewName("modifyUser.jsp");
		return mv;
	}

	// modify a user (admin only)
	@RequestMapping("modifyUser.do")
	private ModelAndView modifyUser(@ModelAttribute("User") @Valid User user, Errors errors, Integer userTypeId) {
		ModelAndView mv = new ModelAndView();

		if (errors.getErrorCount() == 0) {
			// set the user's type
			user.setUsertype(dao.getUserType(userTypeId));
			// update the user using the dao method modifyUser
			dao.modifyUser(user);
			// go back to manager users page
			mv.addObject("User", new User());
			mv.setViewName("manageUsers.jsp");
		} else {
			// back to manager users and retry if there was an error
			mv.addObject("User", user);
			mv.addObject("errorMessage", "Update failed, try again");
			mv.setViewName("manageUsers.jsp");
		}

		return mv;
	}

	// delete user (admin only)
	@RequestMapping("deleteUser.do")
	private ModelAndView deleteUser(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("userId") Integer userId) {
		ModelAndView mv = new ModelAndView();
		// if admin
		if (currentUser.getUsertype().getAccessLevel() > 2) {
			// delete the user using the dao method
			// and go back to the manage users page
			dao.deleteUser(userId);
			mv.addObject("User", new User());
			mv.setViewName("manageUsers.jsp");

		} else {
			// if not admin, back to home page
			mv.setViewName("mainPage.jsp");
		}
		return mv;

	}

	// delete your own account (self delete)
	@RequestMapping("deleteCurrentUser.do")
	private ModelAndView deleteCurrentUser(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("userId") Integer userId) {
		ModelAndView mv = new ModelAndView();
//		pass user's own user id to delete user method in dao
		dao.deleteUser(userId);
		//logout current user by setting to a black user object.
		currentUser = new User();
		//go back to the index / sign in page
		mv.addObject("currentUser", currentUser);
		mv.addObject("User", new User());
		//index accidentally uses lowercase u, so i fixed it by 
		//adding this in addition to the capital U object add:
		mv.addObject("user", new User());
		mv.setViewName("index.jsp");

		return mv;

	}

	//login

	@RequestMapping("login.do")
	private ModelAndView login(User user, @ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		//get login result (user or error) 
		LoginResult result = dao.getUserByLoginCredentials(user);
		if (result.getUser() != null) {
			//get the user form the result and go to the main page
			mv.addObject("currentUser", result.getUser());
			mv.setViewName("mainPage.jsp");
		} else {
			//display a loggin error on the main page
			mv.addObject("LoginError", result.getMessage());
			mv.addObject("user", new User());
			mv.setViewName("index.jsp");
		}
		return mv;

	}

	//setup beer rating page
	@RequestMapping(path = "rateABeer.do", params = "beerId")
	private ModelAndView rateAbeer(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("beerId") Integer beerId) {
		
		ModelAndView mv = new ModelAndView();
		//get a beer from the dao get beer method.
		Beer beerResult = dao.getBeer(beerId);
		//go to the rateabeer page to fill out a beer rating
		mv.addObject("currentUser", currentUser);
		mv.addObject("beer", beerResult);
		mv.setViewName("rateabeer.jsp");

		return mv;
	}

	//submit rating
	@RequestMapping(path = "saveRateABeer.do")
	private ModelAndView saveRatingOfBeer(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("rating") int rating, @RequestParam("beerId") int beer,
			@RequestParam("comments") String comments) {

		/*
		 * The list of beers for a user will not update unless a user logs out
		 * and back in, so I made that happen silently here:
		 */
		int currentUserId = currentUser.getId();
		currentUser = new User();
		currentUser = dao.getUser(currentUserId);
		ModelAndView mv = new ModelAndView();
		//make a new beer rating, beer, and user object
		BeerRating br = new BeerRating();
		Beer beerToBeRated = dao.getBeer(beer);
		User userSelected = dao.getUser(currentUser.getId());
		//set attributes of rating
		br.setUser(userSelected);
		br.setBeer(beerToBeRated);
		br.setComments(comments);
		br.setRating(rating);
		//persist the rating
		dao.addRating(br);
		//go to the user beer list
		mv.addObject("currentUser", currentUser);
		mv.addObject("br", new BeerRating());
		mv.setViewName("findUserBeerList.do");
		return mv;
	}

	//setup modify a rating page
	@RequestMapping("changeARating.do")
	private ModelAndView changeTheRating(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("ratingID") int ratingId) {
		ModelAndView mv = new ModelAndView();
		BeerRating br = dao.getRatingByID(ratingId);
		//add rating and go to edit rating page
		mv.addObject("rating", ratingId);
		mv.addObject("br", br);
		mv.setViewName("editrating.jsp");
		return mv;
	}

	//save modified rating
	@RequestMapping("saveARating.do")
	private ModelAndView saveTheRating(@RequestParam("rating") int rating, @RequestParam("comments") String comment,
			@RequestParam("beerId") int id) {
		ModelAndView mv = new ModelAndView();
		//get rating by dao method
		BeerRating br = dao.getRatingByID(id);
		//set rating object to new stuff
		br.setRating(rating);
		br.setComments(comment);
		//modify rating in database using dao method
		dao.modifyRating(br);
		//go back to user beer list
		mv.setViewName("findUserBeerList.do");

		return mv;
	}
	//remove a rating
	@RequestMapping("deleteRating.do")
	private ModelAndView deleteRating(@RequestParam("ratingId") Integer ratingId,
			@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		//get a beer rating form dao
		BeerRating br = dao.getRatingByID(ratingId);
		//delete using dao method
		dao.deleteRating(currentUser.getId(), br.getId());

		// back to main page
		mv.setViewName("mainPage.jsp");

		return mv;
	}
	//redirect to update profile information page
	@RequestMapping("takeToUpdateProfile.do")
	private ModelAndView updateProfile(@ModelAttribute("currentUser") User currentUser){
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentUser", currentUser);
		mv.setViewName("editProfile.jsp");
		return mv;
	}
	@RequestMapping("updateCurrentUser.do")
	private ModelAndView updateCurrentUser(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("userId") Integer userId,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("picture") String picture) {
		ModelAndView mv = new ModelAndView();
		//pass user's new attribute to gets and sets
		User u = dao.getUser(userId);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setPicture(picture);
		dao.modifyUser(u);
		//logout current user by setting to a blank user object.
//		currentUser = new User();
		//go back to the index / sign in page
		mv.addObject("currentUser", currentUser);
		mv.addObject("User", new User());
		//index accidentally uses lowercase u, so i fixed it by 
		//adding this in addition to the capital U object add:
		mv.addObject("user", new User());
		mv.setViewName("userAccount.jsp");

		return mv;

	}
	@RequestMapping("updateStatus.do")
	private ModelAndView updateStatus(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("statusBox") String status ){
		ModelAndView mv = new ModelAndView();
		User u = dao.getUser(currentUser.getId());
		u.setStatus(status);
		dao.modifyStatus(u);
		
		mv.addObject("currentUser", currentUser);
		mv.addObject("User", new User());
		mv.addObject("user", new User());
		
		User userLogged = new User();

		// re attach current user....
		if (currentUser.getId() > 0) {
			int userId = currentUser.getId();
			currentUser = null;
			currentUser = dao.getUser(userId);

		}

		// get the current user
		userLogged = dao.getUser(currentUser.getId());
		userLogged.setStatus(status);
		mv.addObject("currentUser", userLogged);
		mv.setViewName("userAccount.jsp");
		return mv;
		
	}
	

}








