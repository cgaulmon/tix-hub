package org.tixhub.services;

import java.util.List;
import java.util.Optional;

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
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO register(UserDTO user) throws UsernameExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrincipal findUserPrincipalByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addNewUser(UserDTO user) throws UsernameExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(UserDTO user) throws UsernameExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String username) throws UserDoesNotExistException {
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
	public Optional<User> findUserNameAndSecurePassword(String userName, String pass) {
		pass = encryptPassword(pass);
		return userRepository.findByUserNameAndPassword(userName, pass);
	}

	private String encryptPassword(String pass) {
		return pass;
	}

}
