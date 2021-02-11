package org.tixhub.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Event {

	@Id
	private long id;
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	private double price;
}