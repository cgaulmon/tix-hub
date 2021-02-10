package org.tixhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tixhub.dto.UserDTO;

@RequestMapping("/api/users")
@RestController
public class UserController {
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(UserDTO user) { return null;}
	@PostMapping("/login")
	public ResponseEntity<Object> login(UserDTO user) { return null;}
	@PostMapping("/logout")
	public ResponseEntity<Object> logout(UserDTO user) { return null;}
	@PostMapping("/{id}")
	public ResponseEntity<UserDTO> findByUserId(@PathVariable("id") long id) { return null;}
	
}
