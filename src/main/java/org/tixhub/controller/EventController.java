package org.tixhub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tixhub.dto.EventDTO;
import org.tixhub.dto.EventRSVPDTO;
import org.tixhub.services.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

	private EventService eventService;

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<EventDTO>> findAll() {
		List<EventDTO> events = eventService.findAll().stream()
				.map(EventDTO::new)
				.collect(Collectors.toList());
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@PostMapping("/rsvp")
	public void rsvp(@RequestBody EventRSVPDTO body) {
		eventService.rsvp(body);
	}
	
	@PostMapping("/create")
	public void create(@RequestBody EventDTO body) {
		eventService.create(body);
	}
}
