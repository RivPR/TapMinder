package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.TapMinderDAO;

@Controller
public class TapMinderController {
	@Autowired
	private TapMinderDAO tmDAO;

}
