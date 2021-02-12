package org.tixhub.services;

import java.util.List;
import java.util.Optional;

import org.tixhub.dto.UserDTO;
import org.tixhub.exception.UserDoesNotExistException;
import org.tixhub.exception.UsernameExistException;
import org.tixhub.jpa.entity.User;
import org.tixhub.security.domain.UserPrincipal;

public interface UserService {

    UserDTO register(UserDTO user) throws UsernameExistException;

    List<User> getUsers();

    User findUserByUsername(String username);
    
    UserPrincipal findUserPrincipalByUserId(String userId);

    User findUserByEmail(String email);

    User addNewUser(UserDTO user) throws UsernameExistException;

    User updateUser(UserDTO user) throws  UsernameExistException;

    void deleteUser(String username) throws UserDoesNotExistException;

    void resetPassword(String email) throws UserDoesNotExistException;

    Optional<User> findUserNameAndSecurePassword(String userName, String pass);
  
}
