
package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping(value="/categorylist", method=RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value="/addcategory", method=RequestMethod.GET)
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value="/savecategory", method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category) {
		repository.save(category);
		return "redirect:/categorylist";
	}
	
	@RequestMapping(value="/editcategory/{id}", method=RequestMethod.GET)
	public String editCategory(@PathVariable("id") Long categoryId, Model model) {
		model.addAttribute("category", repository.findById(categoryId).get());
		return "editcategory";
	}
	
	@RequestMapping(value="/deletecategory/{id}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryId) {
		repository.deleteById(categoryId);
		return "redirect:../categorylist";
	}
}
