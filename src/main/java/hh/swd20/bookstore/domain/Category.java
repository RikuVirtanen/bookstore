package hh.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {
		super();
		this.name = null;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return categoryid;
	}

	public void setId(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return this.books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String capitalize(String word) {
		String words[] = word.split("\\s");
		String outcome = "";
		for (String w: words) {
			String first = w.substring(0, 1);
			String rest = w.substring(1);
			outcome += first.toUpperCase() + rest + " ";
		}
		
		return outcome.trim();
	}

	@Override
	public String toString() {
		
		// Do not insert list attributes here!
		return "Category [categoryid=" + categoryid + ", name=" + capitalize(name) + "]";
	}
	
}
