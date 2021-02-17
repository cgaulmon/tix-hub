package org.tixhub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.tixhub.dto.EventDTO;
import org.tixhub.jpa.entity.Event;
import org.tixhub.jpa.repository.EventRepository;


@Service
public class EventService {

	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}
	
	public EventDTO findById(long id) {
		Optional<Event> eventOptional = eventRepository.findById(id);
		if(eventOptional.isPresent()) {
			return new EventDTO(eventOptional.get());
		} else {
			return null;
		}
	}

	public List<Event> findAll() {
		return eventRepository.findAll();
	}
	
	
}
