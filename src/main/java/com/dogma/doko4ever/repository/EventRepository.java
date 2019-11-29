package com.dogma.doko4ever.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dogma.doko4ever.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

	List<Event> findByOrderByEventDateAsc();

	List<Event> findByEventDateGreaterThanOrderByEventDateAsc(LocalDateTime now);

}
