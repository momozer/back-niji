package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
