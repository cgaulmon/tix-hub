package org.tixhub.security.jwt;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;
import org.tixhub.util.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

	public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
		/*
		 * HttpResponse httpResponse = new HttpResponse(FORBIDDEN.value(), FORBIDDEN,
		 * FORBIDDEN.getReasonPhrase().toUpperCase(), FORBIDDEN_MESSAGE);
		 * response.setContentType(APPLICATION_JSON_VALUE);
		 * response.setStatus(FORBIDDEN.value()); OutputStream outputStream =
		 * response.getOutputStream(); ObjectMapper mapper = new ObjectMapper();
		 * mapper.writeValue(outputStream, httpResponse); outputStream.flush();
		 */
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		response.sendRedirect("/user/login");
    }
}
