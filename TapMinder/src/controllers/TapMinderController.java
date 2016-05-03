package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import entities.Neighborhood;
import entities.User;
import entities.UserType;

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

	@RequestMapping(path = "initPage.do", method = RequestMethod.GET)
	public ModelAndView initializeLogin(@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentUser", currentUser);
		mv.addObject("user", new User());
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping(path = "initPage.do", method = RequestMethod.POST)
	public ModelAndView initializeLoginAndIndex(User user, @ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		LoginResult result = dao.getUserByLoginCredentials(user);

		// mv.setViewName("index1.jsp");
		if (result.getUser() != null) {
			System.out.println("new current user: " + currentUser);
			// TODO: better way to set session attributes?
			mv.addObject("currentUser", result.getUser());
			mv.setViewName("indexAlexTest.jsp");
		} else {
			mv.addObject("LoginError", result.getMessage());
			mv.addObject("user", new User());
			mv.setViewName("index1.jsp");
		}
		return mv;
	}

	@RequestMapping("menu.do")
	private ModelAndView menu(@RequestParam("menuChoice") String menuChoice,
			@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();

		// menu actions mapped below
		switch (menuChoice) {
		case "login":
			mv.addObject("user", new User());
			mv.setViewName("AlexTestJSPStuff/login.jsp");
			break;

		case "findBeers":
			mv.addObject("searchSetting", "");
			mv.setViewName("searchBeer.jsp");
			break;
		case "findBreweries":
			mv.addObject("searchSetting", "");
			mv.setViewName("searchBreweries.jsp");
			break;
		case "viewUserBeers":

			mv.setViewName("findUserBeerList.do");
			break;
		case "myAccount":
			// TODO: add real stuff
			mv.setViewName("viewUserAccount.do");
			break;
		case "modifyBreweries":
			// TODO: this will actually probably not be used

			mv.setViewName("index.jsp");
			break;
		case "modifyModerators":

			// TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "modifyUsers":
			if (currentUser.getUsertype().getAccessLevel() > 2) {
				mv.addObject("User", new User());
				mv.setViewName("manageUsers.jsp");
			} else {
				mv.setViewName("indexAlexTest.jsp");
			}
			break;
		case "addUser":
			mv.addObject("User", new User());
			mv.setViewName("addUser.jsp");
			break;
		case "addBreweries":
			// TODO: add real stuff
			mv.addObject("Brewery", new Brewery());
			mv.addObject("neighborhoodList", dao.getNeighborhoods());

			mv.setViewName("addBrewery.jsp");
			break;
		case "signUp":
			// TODO: add real stuff
			mv.addObject("User", new User());

			mv.setViewName("signUp.jsp");
			break;
		case "logout":
			System.out.println("logging out");
			System.out.println(currentUser);
			currentUser = new User();
			System.out.println(currentUser);
			mv.addObject("currentUser", currentUser);
			mv.addObject("user", new User());
			mv.setViewName("index.jsp");
			break;
		default:
			mv.setViewName("index.jsp");
			break;

		}

		return mv;

	}// menu.do

	@RequestMapping("addBeerPage.do")
	private ModelAndView addBeerPage(@RequestParam("breweryId") Integer breweryId) {

		ModelAndView mv = new ModelAndView();

		mv.addObject("Brewery", dao.getBrewery(breweryId));
		mv.addObject("Beer", new Beer());
		mv.setViewName("addBeer.jsp");
		return mv;

	}

	@RequestMapping("addBeer.do")
	private ModelAndView addBeer(Beer beer, @RequestParam("breweryId") Integer breweryId) {
		ModelAndView mv = new ModelAndView();

		beer.setBrewery(dao.getBrewery(breweryId));
		
		dao.addBeer(beer);
		
		mv.addObject("Beer", new Beer());
		mv.setViewName("indexAlexTest.jsp");
		return mv;
	}

	@RequestMapping("modifyBeerPage.do")
	private ModelAndView modifyBeerPage(@RequestParam("beerId") Integer beerId){
	
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("Beer",dao.getBeer(beerId));
		
		mv.setViewName("modifyBeer.jsp");
		return mv;
		
		
		
	}	
	@RequestMapping("modifyBeer.do")
	private ModelAndView modifyBeer(Beer beer){
		ModelAndView mv = new ModelAndView();
		
		dao.modifyBeer(beer);
		
		mv.setViewName("indexAlexTest.jsp");
		return mv;
	}
	//works
	@RequestMapping("deleteBeer.do")
		private ModelAndView deleteBeer(@RequestParam("beerId") Integer beerId){
		ModelAndView mv = new ModelAndView();
		
		
		dao.deleteBeer(beerId);
		
		mv.setViewName("indexAlexTest.jsp");
		return mv;
		
	}
	
	
	@RequestMapping("modifyBreweryPage.do")
	private ModelAndView modifyBrewery(@RequestParam("breweryId") Integer breweryId) {
		ModelAndView mv = new ModelAndView();

		Brewery brewery = dao.getBrewery(breweryId);
		System.out.println("brewery name to mod: " + brewery.getName());
		mv.addObject("Brewery", brewery);
		mv.addObject("neighborhoodList", dao.getNeighborhoods());
		for (Neighborhood n : dao.getNeighborhoods()) {
			System.out.println(n.getName());
		}
		mv.setViewName("modifyBrewery.jsp");
		return mv;
	}

	@RequestMapping("deleteBrewery.do")
	private ModelAndView deleteBrewery(@RequestParam("breweryId") Integer breweryId) {
		ModelAndView mv = new ModelAndView();
		// TODO not passing object
		// dao.deleteBrewery(dao.getBrewery(breweryId));
		dao.deleteBrewery(breweryId);
		System.out.println("should be deleted");
		// mv.addObject("Brewery", brewery);
		mv.setViewName("indexAlexTest.jsp");
		return mv;
	}

	@RequestMapping("modifyBrewery.do")
	private ModelAndView changeBrewery(Brewery brewery, @RequestParam("neighboorHoodId") Integer neighborHoodId) {
		ModelAndView mv = new ModelAndView();

		dao.modifyBrewery(brewery, neighborHoodId);
		mv.addObject("Brewery", brewery);
		mv.setViewName("indexAlexTest.jsp");
		return mv;
	}

	@RequestMapping("addBrewery.do")
	private ModelAndView addBrewery(Brewery brewery, @RequestParam("neighboorHoodId") Integer neighborHoodId) {
		ModelAndView mv = new ModelAndView();

		dao.addBrewery(brewery, neighborHoodId);
		mv.addObject("Brewery", brewery);
		mv.setViewName("indexAlexTest.jsp");
		return mv;
	}

	@RequestMapping("viewUserAccount.do")
	private ModelAndView viewUserAccount(@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("currentUser", currentUser);
		mv.setViewName("userAccount.jsp");

		return mv;
	}

	@RequestMapping("findUserBeerList.do")
	private ModelAndView printUserBeers(@ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		User userLogged = dao.getUser(currentUser.getId());
		List<BeerRating> userRatings = userLogged.getRatings();
		List<Beer> beers = new ArrayList<>();
		if (userRatings != null && userRatings.size() > 0) {
			for (BeerRating beerRating : userRatings) {
				System.out.println(beerRating.getBeer());
				beers.add(beerRating.getBeer());
			}
		}
		currentUser = dao.refreshUser(currentUser);
		mv.addObject("ratings", userRatings);
		mv.addObject("userBeers", beers);
		mv.addObject("currentUser", currentUser);
		mv.setViewName("myBeers.jsp");

		return mv;
	}

	@RequestMapping("findBeersPage.do")
	private ModelAndView findBeers(@RequestParam("findBy") String choice) {

		ModelAndView mv = new ModelAndView();
		String searchSetting = choice;
		mv.addObject("searchSetting", choice);
		mv.addObject("BeerParameters", new BeerParameters());
		mv.setViewName("searchBeer.jsp");

		return mv;
	}

	@RequestMapping("searchBeers.do")
	private ModelAndView searchBeers(@ModelAttribute("currentUser") User currentUser, BeerParameters beerParameters) {
		ModelAndView mv = new ModelAndView();
		List<Beer> beerList = dao.getBeers(beerParameters);
		mv.addObject("beerList", beerList);
		mv.addObject("currentUser", currentUser);
		mv.setViewName("searchResult.jsp");

		return mv;
	}

	@RequestMapping("searchBreweriesPage.do")
	private ModelAndView searchBreweriesPage(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("findBy") String choice) {
		ModelAndView mv = new ModelAndView();
		System.out.println(choice);
		mv.addObject("BreweryParameters", new BreweryParameters());
		mv.addObject("currentUser", currentUser);
		mv.addObject("neighborhoodList", dao.getNeighborhoods());
		mv.addObject("searchSetting", choice);
		mv.setViewName("searchBreweries.jsp");

		return mv;

	}

	@RequestMapping("searchBreweries.do")
	private ModelAndView searchBreweries(BreweryParameters breweryParameters, Integer neighboorHoodId) {
		ModelAndView mv = new ModelAndView();
		// TODO meh..
		if (neighboorHoodId != null) {
			breweryParameters.setNeighborhood(dao.getNeighborhood(neighboorHoodId));
		}
		List<Brewery> breweryList = dao.getBreweries(breweryParameters);
		mv.addObject("breweryList", breweryList);
		mv.setViewName("searchBreweries.jsp");
		return mv;
	}

	@RequestMapping("findUsers.do")
	private ModelAndView findUsers(User user) {
		ModelAndView mv = new ModelAndView();

		List<User> userList = dao.getUsers(user);

		for (User user2 : userList) {
			System.out.println(user2);
		}
		mv.addObject("User", user);
		mv.addObject("userList", userList);
		mv.setViewName("manageUsers.jsp");
		return mv;
	}

	@RequestMapping("addUser.do")
	private ModelAndView addUser(User user, Integer userTypeId) {
		ModelAndView mv = new ModelAndView();
		System.out.println("usertypeid " + userTypeId);
		UserType ut = dao.getUserType(userTypeId);
		System.out.println(ut.getTypeName());
		user.setUsertype(dao.getUserType(userTypeId));
		dao.addUser(user);
		mv.addObject("User", new User());
		mv.setViewName("manageUsers.jsp");
		return mv;
	}

	@RequestMapping("signUp.do")
	private ModelAndView signUp(User user) {
		ModelAndView mv = new ModelAndView();

		user.setUsertype(dao.getUserType(1));
		dao.addUser(user);
		mv.addObject("User", new User());
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping("modifyUserPage.do")
	private ModelAndView modifiyUserPage(@RequestParam("userId") Integer userId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("User", dao.getUser(userId));
		mv.addObject("userTypeList", dao.getUserTypes());
		mv.setViewName("modifyUser.jsp");
		return mv;
	}

	@RequestMapping("modifyUser.do")
	private ModelAndView modifyUser(User user, Integer userTypeId) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user);
		user.setUsertype(dao.getUserType(userTypeId));
		System.out.println(user);
		dao.modifyUser(user);
		mv.addObject("User", new User());
		mv.setViewName("manageUsers.jsp");

		return mv;
	}

	@RequestMapping("deleteUser.do")
	private ModelAndView deleteUser(@RequestParam("userId") Integer userId) {
		ModelAndView mv = new ModelAndView();
		dao.deleteUser(userId);
		// TODO: FINISH
		mv.addObject("User", new User());
		mv.setViewName("manageUsers.jsp");
		return mv;

	}

	@RequestMapping("deleteCurrentUser.do")
	private ModelAndView deleteCurrentUser(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("userId") Integer userId) {
		ModelAndView mv = new ModelAndView();
		dao.deleteUser(userId);
		// TODO: FINISH
		currentUser = new User();
		System.out.println("logged out: now: " + currentUser);
		mv.addObject("currentUser", currentUser);
		mv.addObject("User", new User());
		mv.setViewName("manageUsers.jsp");
		return mv;

	}

	@RequestMapping("login.do")
	private ModelAndView login(User user, @ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		LoginResult result = dao.getUserByLoginCredentials(user);
		if (result.getUser() != null) {
			System.out.println("new current user: " + currentUser);
			// TODO: better way to set session attributes?
			mv.addObject("currentUser", result.getUser());
			mv.setViewName("indexAlexTest.jsp");
		} else {
			mv.addObject("LoginError", result.getMessage());
			mv.addObject("user", new User());
			mv.setViewName("index.jsp");
		}
		return mv;

	}

	// TODO does this do anything?
	@RequestMapping("login1.do")
	private ModelAndView login1(User user, @ModelAttribute("currentUser") User currentUser) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		LoginResult result = dao.getUserByLoginCredentials(user);
		// mv.setViewName("index1.jsp");

		if (result.getUser() != null) {
			System.out.println("new current user: " + currentUser);
			// TODO: better way to set session attributes?
			mv.addObject("currentUser", result.getUser());
			mv.setViewName("index1.jsp");
		} else {
			mv.addObject("LoginError", result.getMessage());
			mv.addObject("user", new User());
			mv.setViewName("index.jsp");
		}
		return mv;

	}

	@RequestMapping(path = "rateABeer.do", params = "beerId")
	private ModelAndView rateAbeer(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("beerId") Integer beer) {

		ModelAndView mv = new ModelAndView();
		Beer beerResult = dao.getBeer(beer);

		mv.addObject("currentUser", currentUser);
		mv.addObject("beer", beerResult);
		mv.setViewName("rateabeer.jsp");
		return mv;
	}

	@RequestMapping(path = "saveRateABeer.do")
	private ModelAndView saveRatingOfBeer(@ModelAttribute("currentUser") User currentUser,
			@RequestParam("rating") int rating, @RequestParam("beerId") int beer,
			@RequestParam("comments") String comments) {

		ModelAndView mv = new ModelAndView();
		BeerRating br = new BeerRating();
		Beer beerToBeRated = dao.getBeer(beer);
		User userSelected = dao.getUser(currentUser.getId());
		br.setUser(userSelected);
		br.setBeer(beerToBeRated);
		br.setComments(comments);
		br.setRating(rating);
		dao.addRating(br);
		mv.addObject("currentUser", currentUser);
		mv.addObject("br", new BeerRating());
		mv.setViewName("indexAlexTest.jsp");
		return mv;
	}
	@RequestMapping("changeARating.do")
	private ModelAndView changeTheRating(@ModelAttribute("currentUser") User currentUser, 
										 @RequestParam("ratingID") int ratingId ){
		ModelAndView mv = new ModelAndView();
		BeerRating br = dao.getRatingByID(ratingId);
		mv.addObject("rating", ratingId);
		mv.addObject("br", br);
		mv.setViewName("editrating.jsp");
		return mv;
	}
	
	@RequestMapping("saveARating.do")
	private ModelAndView saveTheRating(@RequestParam("rating") int rating, 
									   @RequestParam("comments") String comment,
									   @RequestParam("ratingID") int id){
		ModelAndView mv = new ModelAndView();
		BeerRating br = dao.getRatingByID(id);
	
		br.setRating(rating);
		br.setComments(comment);
		
		dao.modifyRating(br);

		mv.setViewName("findUserBeerList.do");
		
		return mv;
	}

}
