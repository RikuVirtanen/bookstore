package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.web.BookstoreController;
import hh.swd20.bookstore.web.CategoryController;
import hh.swd20.bookstore.web.UserController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookstoreController bookstoreController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(bookstoreController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(userController).isNotNull();
	}

}
