package com.ems.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	/** FORM ACTION MUST BE [/Login]  **/
	@RequestMapping(value="/Login", method = RequestMethod.GET)
	public String login() {
	   
	    return "LoginPage";
	}
	
	
	@RequestMapping(value="/Logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:Login";
	}
	
	
	@RequestMapping(value="/AccessDenied", method = RequestMethod.GET)
	public String errorPage(Model model) {
	    model.addAttribute("cause", "You are not authorized to access this URL.");
	    return "ErrorPage";
	}
}
