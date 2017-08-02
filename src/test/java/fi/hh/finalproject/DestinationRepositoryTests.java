package fi.hh.finalproject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.finalproject.domain.Category;
import fi.hh.finalproject.domain.Destination;
import fi.hh.finalproject.domain.DestinationRepository;

/*Testing for search, create and delete functionalities, and finding destination by id in DestinationRepository.*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class DestinationRepositoryTests {
	@Autowired
	private DestinationRepository repository;
	
	//searching destination by name
	@Test
	public void searchByDestinationName() throws Exception {
		List<Destination> destination = repository.findByDestinationName("Bangkok");
		assertThat(destination).hasSize(1);
		assertThat(destination.get(0).getProvince()).isEqualTo("Bangkok");
	}
	
	//creating a new destination
	@Test
	public void createNewDestination() throws Exception {
		Destination destination = new Destination("Chiang Mai","Chiang Mai","temples,shopping,nature and landscapes",5,new Category("City"));
		repository.save(destination);
		assertThat(destination.getId()).isNotNull();
	}
	
	//deleting a destination
	@Test
	public void deleteDestination() throws Exception {
		List<Destination> destination = repository.findByDestinationName("Bangkok");
		repository.delete(destination);
		assertThat(destination).hasSize(1);
		assertThat(destination.get(0).getProvince()).isEqualTo("Bangkok");
		
	}
	
	//getting destination by id
	@Test
	public void getDestinationById() throws Exception {
		List<Destination> destination = repository.findById(1);
		assertThat(destination.get(0).getDestinationName()).isEqualTo("Bangkok");
	}

}
