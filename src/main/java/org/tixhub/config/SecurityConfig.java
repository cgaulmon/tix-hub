package org.tixhub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.tixhub.security.CustomSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String[] PUBLIC_URLS = { "/", "/favicon.ico", "/css/**", "/js/**", "/api/events/**",
			"/user/login", "/user/register", "/user/resetPassword", "/user/tempPassword", "/csrf", "/v2/api-docs",
			"/swagger-resources/configuration/ui", "/configuration/ui", "/swagger-resources",
			"/swagger-resources/configuration/security", "/configuration/security", "/swagger-ui.html", "/webjars/**" };
	
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Autowired
	public SecurityConfig(
			@Qualifier("userDetailsService")UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers(PUBLIC_URLS).permitAll()
		.and().authorizeRequests().antMatchers("/admin/dashboard").hasAnyRole("ADMIN")
				.antMatchers("/user/dashboard").hasAnyRole("USER").and().formLogin().loginPage("/user/login")
				.loginProcessingUrl("/user_login")
		          .failureUrl("/loginUser?error=loginError").defaultSuccessUrl("/user/dashboard").permitAll().and()
				.logout().logoutUrl("/user_logout").logoutSuccessUrl("/user/login").deleteCookies("JSESSIONID")
                .permitAll();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/webjars/**");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}