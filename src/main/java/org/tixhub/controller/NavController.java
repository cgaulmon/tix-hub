package org.tixhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.tixhub.services.EventService;

@Controller
public class NavController {

	private EventService eventService;
	
	public NavController(EventService eventService) {
		super();
		this.eventService = eventService;
	}

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
		map.put("events", eventService.findAll());
		return "events";
	}
	
	@GetMapping("/events/{id}")
	public String getEventDetailsView(@PathVariable("id") int id, ModelMap map) {
		map.put("event",eventService.findById(id));
		return "event_detail";
	}
	
	@GetMapping("/events/create")
	public String getCreateEventView() {
		return "events/new";
	}
	
	@GetMapping("/events/manage")
	public String getManageView() {
		return "events/manage";
	}
}


