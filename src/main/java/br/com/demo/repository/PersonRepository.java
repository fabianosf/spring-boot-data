package br.com.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.demo.models.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{

	//Page<Person> findByEventId(Event eventId, Pageable pageable);
	
}
