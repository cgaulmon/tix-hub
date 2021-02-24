package org.tixhub.dto;

import java.util.Date;

import org.tixhub.jpa.entity.User;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy", timezone = "US/Central")
	private Date joinDate;
	private String[] authorities;
	
	
	public UserDTO(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.joinDate = user.getJoinDate();
		this.authorities = user.getAuthorities();
	}
}
