package org.tixhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping({ "", "/" })
	public String getHomeView() {
		return "home";
	}

	@GetMapping("/user/register")
	public String registerUserView() {
		return "register";
	}
	
	@GetMapping("/user/resetPassword")
	public String resetPasswordView() {
		return "resetPassword";
	}
	
	@GetMapping("/user/tempPassword")
	public String tempPasswordView() {
		return "tempPassword";
	}
	
	@GetMapping("/user/login")
	public String getLoginView() {
		return "login";
	}
	
	@GetMapping("/user/logout")
	public String getLogout() {
		return "redirect:/user/login";
	}
	
	@GetMapping("/events")
	public String getEventsView(ModelMap map) {
		return "events";
	}
}


