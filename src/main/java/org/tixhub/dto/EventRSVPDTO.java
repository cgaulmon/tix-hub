package org.tixhub.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EventRSVPDTO {
	private Date rsvpDate;
	private int eventId;
	private int userId;
	private String name;
	private int numOfTickets;
	private String email;
	

}
