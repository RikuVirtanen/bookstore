package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		Optional<Category> category = repository.findByName("Horror");
		
		assertThat(category).isNotEmpty();
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Test");
		repository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		repository.deleteById(repository.findByName("Horror").get().getId());
		assertThat(repository.findByName("Horror")).isEmpty();
	}
}
