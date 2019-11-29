package com.dogma.doko4ever.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dogma.doko4ever.model.Event;
import com.dogma.doko4ever.model.Player;
import com.dogma.doko4ever.repository.EventRepository;
import com.dogma.doko4ever.repository.PlayerRepository;

@Controller
public class EventController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EventRepository rep;

	@Autowired
	private PlayerRepository playerrep;

	@ModelAttribute("players")
	public Iterable<Player> getPlayers() {
		return playerrep.findAll();
	}

	@GetMapping("/events")
	public String getEvents(Model model) {

		model.addAttribute("events", rep.findByOrderByEventDateAsc());

		return "events";

	}

	@GetMapping(value = { "/event", "/event/{id}" })
	public String detailMember(Model model, @PathVariable(required = false, name = "id") Long id) {

		if (null != id) {
			Optional<Event> ev = rep.findById(id);
			model.addAttribute("event", ev.get());
		} else {
			Event ev = new Event();
			// ev.initEventResults(playerrep.findAll());
			model.addAttribute("event", ev);
		}

		return "event_detail";
	}

	@PostMapping("/event")
	public String saveEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			logger.debug(("There was a error " + bindingResult));
			return "event_detail";
		}

		if (event.getId() == null) {
			// safe first - error transient instance must be saved before current operation
			rep.save(event);
			event.initEventResults(playerrep.findAll());
		}

		event.calcAmount(10, 10);
		rep.save(event);

		return "redirect:event/" + event.getId();

	}

	@GetMapping("/delevent/{id}")
	public String deleteEvent(@PathVariable("id") long id) {
		rep.deleteById(id);
		return "redirect:/events";
	}

}
