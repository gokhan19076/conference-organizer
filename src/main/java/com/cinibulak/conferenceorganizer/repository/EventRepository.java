package com.cinibulak.conferenceorganizer.repository;

import com.cinibulak.conferenceorganizer.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
