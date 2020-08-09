package com.cdk.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.cdk.utils.BaseLogger.log;

@Controller
public class BaseController {

    //Counter to show the number of page views of the application
	private static int counter = 1;
	private static final String VIEW_INDEX = "index";
	private static final String LOGIN_VIEW = "loggedIn";

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", counter+=counter);
		logger.debug("[welcome] counter : {}", counter);
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("username") String username){
		log("In /login username: %s ", username);
		model.addAttribute("message", "Welcome " + username);
		return LOGIN_VIEW;
	}

}