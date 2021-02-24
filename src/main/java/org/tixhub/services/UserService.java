package org.tixhub.services;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tixhub.dto.UserDTO;
import org.tixhub.exception.UserDoesNotExistException;
import org.tixhub.exception.UsernameExistException;
import org.tixhub.jpa.entity.User;
import org.tixhub.jpa.repository.UserRepository;
import org.tixhub.security.domain.UserPrincipal;

@Service
@Qualifier("userDetailsService")
public class UserService implements IUserService, UserDetailsService {

	private UserRepository userRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO register(UserDTO newUser) throws UsernameExistException {
	    LOGGER.info("Registering a new user {}", newUser.getUserName());
		User user = new User();
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setRole("USER");
		user.setNotLocked(true);
		user.setJoinDate(Date.from(Instant.now()));
	    userRepository.save(user);	    
		return new UserDTO(user);
	}

	@Override
	public List<UserDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findByUsername(String username) throws UserDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrincipal findUserPrincipalByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findByEmail(String email) throws UserDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO add(UserDTO user) throws UsernameExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO update(UserDTO user) throws UsernameExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String username) throws UserDoesNotExistException {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetPassword(String email) throws UserDoesNotExistException {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findUserNameAndSecurePassword(String userName, String pass) throws UserDoesNotExistException {
		Optional<User> userOptional = userRepository.findByUserNameAndPassword(userName, encryptPassword(pass));
		if(userOptional.isPresent()) {
			return new UserDTO(userOptional.get());
		} else {
			throw new UserDoesNotExistException();
		}
	}

	private String encryptPassword(String pass) {
		return pass;
	}

}
