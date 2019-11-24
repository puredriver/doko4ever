package com.dogma.doko4ever.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dogma.doko4ever.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
