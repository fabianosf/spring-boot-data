package br.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.models.Event;
import br.com.demo.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {	
	
	 
	@Autowired
	private EventRepository eventRepository;
	
	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@GetMapping
	@ResponseBody
	//paginacao
	public Page<Event> findAll(Pageable pageable){
		Page<Event> events = this.eventRepository.findAll(pageable);		
		return events;
	}
	
	@PostMapping
	@ResponseBody
	public Event create(@RequestBody Event event) {
		this.eventRepository.save(event);		
		return event;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
