package hh.swd20.bookstore.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByAuthor(String author);
	List<Book> findByTitle(String title);
	Optional<Book> findById(Long id);
}
