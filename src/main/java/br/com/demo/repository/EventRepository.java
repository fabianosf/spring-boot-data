package br.com.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.demo.models.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>{
	
	 

}
