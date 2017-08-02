package fi.hh.finalproject;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.finalproject.domain.User;
import fi.hh.finalproject.domain.UserRepository;

//creating tests for searching, creating and deleting functionalities for UserRepository

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	@Autowired
	private UserRepository repository;
	
	//searching a user
	@Test
	public void searchUser() throws Exception {
		User user = repository.findByUsername("Administrator");
		assertThat(user.getRole()).isEqualTo("ADMIN");
	}
	
	//creating a new user (Isabel,salasana)
	@Test
	public void createUser() throws Exception {
		User user = new User("Isabel","$2a$10$r75CRTox2Tkh9GkzEJEDWOlnCdgsStq40lh8E7dVntjNVjlG2Io9C","USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
		assertThat(user.getPasswordHash()).isNotNull();
		assertThat(user.getRole()).isNotNull();
		assertThat(user.getUsername()).isNotNull();
	}
	
	//deleting user
	@Test
	public void deleteUser() throws Exception {
		User user = repository.findByUsername("User");
		repository.delete(user);
		assertThat(user.getPasswordHash()).isEqualTo("$2a$10$X5QadUovgPqtE73C3Q.MXeQw1jNnntBIo7vIRYNb511WwQZq31gBW");
		assertThat(user.getRole()).isEqualTo("USER");
	}

}
