package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreApp(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("insert example data to database");
			
			Category horror = new Category("horror");
			categoryRepository.save(horror);
			Category historical = new Category("historical");
			categoryRepository.save(historical);
			Category fiction = new Category("fiction");
			categoryRepository.save(fiction);
			
			log.info("fetch all categories");
			for(Category category: categoryRepository.findAll()) {
				log.info(category.toString());
			}
			/*******************
			private String title;
			private String author;
			private int year;
			private String isbn;
			private double price; 
			********************/
			bookRepository.save(new Book("Cloud Atlas", "David Mitchell", 2004, "9781444730876", fiction));
			bookRepository.save(new Book("The Hunger Games", "Suzanne Collins", 2008, "978-0-439-02348-1", fiction));
			
			// create users: admin/admin user/user
			userRepository.save(new User("user", "$2a$10$7fDUJhaHcW..lozviLnwbuOw6G8VK/tHq4ew/Vo5J47LEX/SUv/KS", "USER"));
			userRepository.save(new User("admin", "$2a$10$FfqOrHQA9ACQQCVIM7wSNeQqfMN/Seix1zVjWgQWPSbiI4qL7dFo6", "ADMIN"));
			
			
			log.info("fetch all books");
			for(Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
