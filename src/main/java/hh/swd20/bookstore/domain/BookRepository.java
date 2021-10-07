package hh.swd20.bookstore.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface BookRepository extends CrudRepository<Book, Long> {

	/*List<Book> findByAuthor(String author);
	Optional<Book> findByTitle(String title);
	Optional<Book> findById(Long id);*/
	
	@RestResource
	public List<Book> findByAuthor(@Param("author") String author);
	
	@RestResource
	public Optional<Book> findByTitle(@Param("title") String name);
	
	@RestResource
	public List<Book> findByYear(@Param("year") int year);
}
