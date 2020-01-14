package com.dogma.doko4ever.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dogma.doko4ever.repository.EventRepository;

@Controller
public class IndexController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EventRepository rep;

	@GetMapping("/")
	public String getIndex(Model model) {

		// model.addAttribute("events",
		// rep.findByEventDateGreaterThanOrderByEventDateAsc(LocalDateTime.now()));

		return "index";

	}

}
