package org.tixhub.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tixhub.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserNameAndPassword(String userName, String pass);

}
