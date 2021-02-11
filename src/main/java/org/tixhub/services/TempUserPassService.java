package org.tixhub.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.tixhub.dto.TempPasswordUserDTO;

@Service
public class TempUserPassService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TempUserPassService.class);
	private NamedParameterJdbcTemplate jdbcTemplate;

	public TempUserPassService(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public TempPasswordUserDTO createTempUserPassword(String userName) throws NoSuchAlgorithmException {
		LOGGER.info("Generating tempPassword for user {} ", userName);
		String pass = generateTempPassword();
		String sql = "INSERT INTO temp_user (load_date, user_name, temp_pass) values (:load_date, :user_name, :temp_pass)";
		MapSqlParameterSource params = new MapSqlParameterSource("load_date", new Date())
										.addValue("user_name", userName)
										.addValue("temp_pass",pass);
		jdbcTemplate.update(sql, params);
		return new TempPasswordUserDTO(userName, pass);
	}

	private String generateTempPassword() throws NoSuchAlgorithmException {
		int aInASCII = 97; // ascii value for a
		int zInASCII = 122; // ascii value for z
		int targetStringLength = 10;
		Random random = SecureRandom.getInstanceStrong();
		
		return random.ints(aInASCII, zInASCII + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
}
