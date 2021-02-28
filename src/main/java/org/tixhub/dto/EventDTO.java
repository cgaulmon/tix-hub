package org.tixhub.dto;

import java.util.Date;

import org.tixhub.jpa.entity.Event;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class EventDTO {

	private long id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private double price;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm", timezone = "US/Central")
	private Date eventDate;
	private long numberOfTickets;

	public EventDTO(Event event) {
		this.eventDate = event.getEventDate();
		this.name = event.getName();
		this.shortDescription = event.getShortDescription();
		this.longDescription = event.getLongDescription();
		this.price = event.getPrice();
		this.eventDate = event.getEventDate();
	}
	
	
}
