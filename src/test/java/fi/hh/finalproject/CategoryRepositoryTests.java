package fi.hh.finalproject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.finalproject.domain.CategoryRepository;
import fi.hh.finalproject.domain.Category;

/*Testing for search, create and delete functionalities for CategoryRepository.*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {
	@Autowired
	private CategoryRepository repository;
	
	//searching category
	@Test
	public void searchCategory() throws Exception {
		List<Category> category = repository.findByName("Natural park");
		assertThat(category).hasSize(1);
		
	}
	
	//creating category
	@Test
	public void creatingNewCategory() throws Exception {
		Category category = new Category("Holiday resort");
		repository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	//deleting category
	@Test
	public void deleteCategory() throws Exception {
		List<Category> category = repository.findByName("City");
		repository.delete(category);
		assertThat(category).hasSize(1);
	}

}
