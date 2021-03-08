package org.tixhub.services;

import java.util.List;

import org.tixhub.dto.EventDTO;
import org.tixhub.dto.EventRSVPDTO;
import org.tixhub.jpa.entity.Event;

public interface IEventService {
	public EventDTO findById(long id);
	public List<Event> findAll();
	public EventRSVPDTO rsvp(EventRSVPDTO newRSVP);
	public EventDTO create(EventDTO newEvent);
	

}
