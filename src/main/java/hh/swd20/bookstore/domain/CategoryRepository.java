package hh.swd20.bookstore.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	/*Optional<Category> findByName(String name);
	Optional<Category> findById(Long id);*/
	
	@RestResource
	public Optional<Category> findByName(@Param("name") String name);
	
	@RestResource
	public Optional<Category> findById(@Param("categoryid") Long categoryid);
}
