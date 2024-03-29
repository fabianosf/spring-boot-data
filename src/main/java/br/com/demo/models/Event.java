package br.com.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;
	
	@Column
	private Double value;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
	private List<Person> people;

	public Event() {

	}

	public Event(Long id, String name, Double value) {		
		this.id = id;
		this.name = name;
		this.value = value;
	}
	
	public Event(String name, Double value) {				
		this.name = name;
		this.value = value;
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
