package br.com.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "people")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String name;	
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	@JsonBackReference
	private Event eventId;
	
	public Person() {
		
	}

	public Person(Long id, String name, Event event) {		
		this.id = id;
		this.name = name;
		this.setEventId(event);
		
	}
	
	public Person(String name, Event event) {			
		this.name = name;
		this.setEventId(event);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Event getEventId() {
		return eventId;
	}

	public void setEventId(Event eventId) {
		this.eventId = eventId;
	}

	
	
	
	
	
	
	

}
