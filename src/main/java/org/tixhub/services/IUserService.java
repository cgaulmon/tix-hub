package org.tixhub.services;

import java.util.List;

import org.tixhub.dto.UserDTO;
import org.tixhub.exception.UserDoesNotExistException;
import org.tixhub.exception.UsernameExistException;
import org.tixhub.security.domain.UserPrincipal;

public interface IUserService {

    UserDTO register(UserDTO user) throws UsernameExistException;

    List<UserDTO> getAll();

    UserDTO findByUsername(String username) throws UserDoesNotExistException;
    
    UserPrincipal findUserPrincipalByUserId(String userId);

    UserDTO findByEmail(String email) throws UserDoesNotExistException;

    UserDTO add(UserDTO user) throws UsernameExistException;

    UserDTO update(UserDTO user) throws UsernameExistException;

    void delete(String username) throws UserDoesNotExistException;

    void resetPassword(String email) throws UserDoesNotExistException;

    UserDTO findUserNameAndSecurePassword(String userName, String pass) throws UserDoesNotExistException;
  
}
