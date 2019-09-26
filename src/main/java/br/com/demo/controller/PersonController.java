package br.com.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.models.Event;
import br.com.demo.models.Person;
import br.com.demo.repository.EventRepository;
import br.com.demo.repository.PersonRepository;

@RestController
@RequestMapping("/events/{eventId}/people") //recebendo eventId para o relacionamento da classe Person 
public class PersonController {

	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	public PersonController(PersonRepository personRepository, EventRepository eventRepository) {
		this.personRepository = personRepository;
		this.eventRepository = eventRepository;
	}
	
	@GetMapping
	@RequestMapping
	//busca todas as pessoas envolvidas no evento
	public List<Person> findAll(@PathVariable("eventId")Long eventId){
		Event event = this.eventRepository.findOne(eventId);
		List<Person> people = event.getPeople().stream().collect(Collectors.toList());
		return people;
		
		
		//return (List<Person>) this.personRepository.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public Person create(@PathVariable("eventId") Long eventId, @RequestBody Person person) {		 
		 Event event = this.eventRepository.findOne(eventId);
		 
		 person.setEventId(event);
		 
		 return this.personRepository.save(person);
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
