package org.tixhub.dto;

import java.util.Date;

import org.tixhub.jpa.entity.Event;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDTO {

	private long id;
	private String name;
	private String description;
	private double price;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy", timezone = "US/Central")
	private Date eventDate;

	public EventDTO(Event event) {
		this.eventDate = event.getEventDate();
		this.name = event.getName();
		this.description = event.getDescription();
		this.price = event.getPrice();
		this.eventDate = event.getEventDate();
	}
	
	
}
