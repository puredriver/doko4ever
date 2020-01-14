package com.dogma.doko4ever.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dogma.doko4ever.model.Cashbox;
import com.dogma.doko4ever.model.Event;
import com.dogma.doko4ever.repository.CashboxRepository;
import com.dogma.doko4ever.repository.EventRepository;

@Controller
public class CashboxController {
	@Autowired
	private CashboxRepository rep;

	@Autowired
	private EventRepository eventRep;

	@GetMapping("/cashbox")
	public String getEvents(Model model) {

		List<Cashbox> cashbox = rep.findByOrderByInventoryDateDesc();
		model.addAttribute("cashbox", cashbox);

		// from events since last inventory date
		Cashbox lastInventory = cashbox.get(0);
		LocalDateTime arg = lastInventory.getInventoryDate().atStartOfDay();
		List<Event> eventsAfterlastInventory = eventRep.findByEventDateAfter(arg);

		BigDecimal amount = new BigDecimal(0);
		for (Event event : eventsAfterlastInventory) {
			amount = amount.add(event.calcResultEUR());
		}

		amount = amount.add(lastInventory.getAmount());
		model.addAttribute("amount", amount);

		return "cashbox";

	}
}
