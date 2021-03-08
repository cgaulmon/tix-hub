package org.tixhub.jpa.entity;

import java.util.Date;

import lombok.Data;

@Data
public class RSVP {

	private long id;
	private long eventId;
	private Date rsvpDate;
	private long numberOfTickets;
	private String email;
	private String firstName;
	private String lastName;
}
