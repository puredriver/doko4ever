package com.dogma.doko4ever.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dogma.doko4ever.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

	List<Event> findByOrderByEventDateDesc();

	List<Event> findByEventDateAfter(LocalDateTime inventoryDate);

}
