package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByAuthorShouldReturnListOfBooks() {
		List<Book> books = repository.findByAuthor("David Mitchell");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Cloud Atlas");
	}
	
	@Test
	public void findByTitleShouldReturnBook() {
		Optional<Book> book = repository.findByTitle("Cloud Atlas");
		assertThat(book).isNotEmpty();
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Test Author", "Test Book", 2021, "test-isbn", null);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		repository.deleteById(repository.findByTitle("Cloud Atlas").get().getId());
		assertThat(repository.findByTitle("Cloud Atlas")).isEmpty();
	}
}
