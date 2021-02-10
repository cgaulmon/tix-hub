package org.tixhub.controller;

import org.springframework.stereotype.Controller;
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
}
