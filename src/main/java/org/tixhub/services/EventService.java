package org.tixhub.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tixhub.dto.EventDTO;
import org.tixhub.dto.EventRSVPDTO;
import org.tixhub.jpa.entity.Event;
import org.tixhub.jpa.repository.EventRepository;


@Service
public class EventService implements IEventService {

	private EventRepository eventRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);
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

	public EventRSVPDTO rsvp(EventRSVPDTO body) {
		return null;		
	}

	public EventDTO create(EventDTO newEvent) {
		LOGGER.info("results {} ", newEvent);
		Event event = new Event();
		event.setName(newEvent.getName());
		event.setShortDescription(newEvent.getShortDescription());
		event.setLongDescription(newEvent.getLongDescription());
		event.setAvailableTickets(newEvent.getNumberOfTickets());
		event.setEventDate(newEvent.getEventDate());
		return new EventDTO(eventRepository.save(event));
		
	}
	
	
}
