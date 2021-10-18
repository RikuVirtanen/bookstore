
package hh.swd20.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository repository;
	
	/************* RESTful services **********************/
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public @ResponseBody List<Category> getCategoriesRest() {
		return (List<Category>) repository.findAll();
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
		return repository.findById(categoryId);
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
		return repository.save(category);
	}
	
	/******************************************************/
	
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
		if(!repository.findByName(category.getName().toLowerCase()).isEmpty()) {
			return "redirect:/categorylist";
		}
		category.setName(category.getName().toLowerCase());
		repository.save(category);
		return "redirect:/categorylist";
	}
	@PreAuthorize(value="hasAuthority('ADMIN')")
	@RequestMapping(value="/editcategory/{id}", method=RequestMethod.GET)
	public String editCategory(@PathVariable("id") Long categoryId, Model model) {
		model.addAttribute("category", repository.findById(categoryId).get());
		return "/editcategory";
	}
	@PreAuthorize(value="hasAuthority('ADMIN')")
	@RequestMapping(value="/deletecategory/{id}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryId) {
		repository.deleteById(categoryId);
		return "redirect:../categorylist";
	}
}
