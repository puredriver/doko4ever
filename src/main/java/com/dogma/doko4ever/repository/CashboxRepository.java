package com.dogma.doko4ever.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dogma.doko4ever.model.Cashbox;

public interface CashboxRepository extends CrudRepository<Cashbox, Long> {

	List<Cashbox> findByOrderByInventoryDateDesc();

}
