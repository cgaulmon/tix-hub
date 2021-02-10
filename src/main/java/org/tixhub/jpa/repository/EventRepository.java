package org.tixhub.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tixhub.jpa.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
