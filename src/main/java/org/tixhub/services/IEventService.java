package org.tixhub.services;

import java.util.List;

import org.tixhub.dto.EventRSVPDTO;
import org.tixhub.jpa.entity.Event;

public interface IEventService {
	
	public List<Event> findAll();
	public void rsvp(EventRSVPDTO body);
	

}
