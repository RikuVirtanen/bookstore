package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/index")
	public String getIndex(Model model) {
		return "bookstore";
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		// jos id arvo on 0 tai null - SQL insert muuten SQL update 
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId).get());
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
}
