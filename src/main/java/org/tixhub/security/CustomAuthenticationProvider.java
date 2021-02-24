package org.tixhub.security;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.tixhub.dto.UserDTO;
import org.tixhub.exception.UserDoesNotExistException;
import org.tixhub.services.IUserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private IUserService userService;

	public CustomAuthenticationProvider(IUserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) {
		String userName = authentication.getName();
		String pass = authentication.getCredentials().toString();

		UserDTO user;
		try {
			user = userService.findUserNameAndSecurePassword(userName, pass);
			List<GrantedAuthority> authorities = stream(user.getAuthorities())
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
			return new UsernamePasswordAuthenticationToken(userName, pass, authorities);
		} catch (UserDoesNotExistException e) {
			throw new IllegalStateException(e);
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
