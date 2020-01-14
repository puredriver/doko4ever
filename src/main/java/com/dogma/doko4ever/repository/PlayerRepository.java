package com.dogma.doko4ever.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dogma.doko4ever.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

	List<Player> findByActive(int active);

}
