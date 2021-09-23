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

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreApp(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			
			log.info("insert example data to database");
			
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Historical"));
			categoryRepository.save(new Category("Fiction"));
			
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
			bookRepository.save(new Book("Cloud Atlas", "David Mitchell", 2004, "9781444730876"));
			bookRepository.save(new Book("The Hunger Games", "Suzanne Collins", 2008, "978-0-439-02348-1"));
			
			log.info("fetch all books");
			for(Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
