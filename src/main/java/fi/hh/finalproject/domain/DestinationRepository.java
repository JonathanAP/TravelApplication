package fi.hh.finalproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DestinationRepository extends CrudRepository<Destination, Long> {
	//creating repository with query methods
	List<Destination> findByDestinationName(String destinationName);
	List<Destination> findById(long id);
}
