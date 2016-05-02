package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.TapMinderDAO;
import entities.User;

/*
 * I just made this to test out the stuff we learned in class
 */
@Controller
@SessionAttributes({"currentUser"})
public class AlexTestController {

	@ModelAttribute("currentUser")
	private User setBlankCurrentUser(){
		User user = new User();
		return user;
	}
	
	@Autowired
	private TapMinderDAO dao;

	@RequestMapping("menu.do")
	private ModelAndView menu(@RequestParam("menuChoice") String menuChoice) {
		ModelAndView mv = new ModelAndView();

		// menu actions mapped below
		switch (menuChoice) {
		case "login":
			mv.addObject("user",new User());
			mv.setViewName("AlexTestJSPStuff/login.jsp");
			break;
			
		case "findBeers":
			//TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "findBreweries":
			//TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "viewUserBeers":
			//TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "myAccount":
			//TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "modifyBreweries":
			//TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "modifyModerators":
			//TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		case "modifyUsers":
			//TODO: add real stuff
			mv.setViewName("index.jsp");
			break;
		default:
			mv.setViewName("index.jsp");
			break;

		}

		return mv;

	}//menu.do
	
	@RequestMapping("login.do")
	private ModelAndView login(User user, @ModelAttribute("currentUser") User currentUser){
		ModelAndView mv = new ModelAndView();
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		currentUser = dao.getUserByLoginCredentials(user);
		System.out.println("new current user: " + currentUser);
		mv.addObject("currentUser",currentUser);
		mv.setViewName("indexAlexTest.jsp");
		return mv;
		
	}

}
