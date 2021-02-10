package org.tixhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tixhub.services.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

	private EventService eventService;

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	
	
}
