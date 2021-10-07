package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookstoreController {
	
	@RequestMapping(value="/index")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value="/categories")
	public String getCategories() {
		return "categories";
	}
	
	/*@RequestMapping(value="/books", method=RequestMethod.GET)
	public String navToBooklist(Model model) {
		return "booklist";
	}*/
	
}
