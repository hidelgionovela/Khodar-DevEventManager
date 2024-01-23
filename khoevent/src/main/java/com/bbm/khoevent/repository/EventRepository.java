package com.bbm.khoevent.repository;

import com.bbm.khoevent.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
