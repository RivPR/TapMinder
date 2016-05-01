package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.TapMinderDBDAO;

/*
 * I just made this to test out the stuff we learned in class
 */
@Controller
public class AlexTestController {

	//TODO: autowired is not working
//	@Autowired
//	private TapMinderDBDAO dao;

	@RequestMapping("menu.do")
	private ModelAndView menu(@RequestParam("menuChoice") String menuChoice) {
		ModelAndView mv = new ModelAndView();

		// menu actions mapped below
		switch (menuChoice) {
		case "login":
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

	}

}
