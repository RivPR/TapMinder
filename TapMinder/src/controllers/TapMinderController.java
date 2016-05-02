package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.BeerParameters;
import data.LoginResult;
import data.TapMinderDAO;
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
			// TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "viewUserBeers":
			// TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "myAccount":
			// TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "modifyBreweries":
			// TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "modifyModerators":
			// TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "modifyUsers":
			// TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "logout":
			System.out.println("logging out");
			System.out.println(currentUser);
			currentUser = new User();
			System.out.println(currentUser);
			mv.addObject("currentUser", currentUser);
			mv.setViewName("indexAlexTest.jsp");
			break;
		default:
			mv.setViewName("index.jsp");
			break;

		}

		return mv;

	}// menu.do

	@RequestMapping("findBeersPage.do")
	private ModelAndView findBeers(@RequestParam("findBy") String choice) {

		ModelAndView mv = new ModelAndView();
		String searchSetting = choice;
		mv.addObject("searchSetting", choice);
		mv.addObject("BeerParameters",new BeerParameters());
		mv.setViewName("searchBeer.jsp");

		return mv;
	}

	@RequestMapping("searchBeers.do")
	private ModelAndView searchBeers(BeerParameters beerParameters) {
		ModelAndView mv = new ModelAndView();
		System.out.println("lsdkjfa;slkdsa;dlka;sodjfsal;kdfyayayyayayayayayay");
		
		mv.setViewName("indexAlexTest.jsp");
		
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
			mv.setViewName("AlexTestJSPStuff/login.jsp");
		}
		return mv;

	}

}
