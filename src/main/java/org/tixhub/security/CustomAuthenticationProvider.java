package org.tixhub.security;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.tixhub.jpa.entity.User;
import org.tixhub.services.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private UserService userService;
	
	public CustomAuthenticationProvider(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication){
		String userName = authentication.getName();
		String pass = authentication.getCredentials().toString();
		
		Optional<User> userOptional = userService.findUserNameAndSecurePassword(userName,pass);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			List<GrantedAuthority> authorities = stream(user.getAuthorities())
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
			return new UsernamePasswordAuthenticationToken(userName,pass,authorities);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
