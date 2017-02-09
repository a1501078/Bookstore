package com.maria.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maria.domain.Book;
import com.maria.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 

	@RequestMapping(value="/index")
	public String book(@RequestParam(value="title") String title, @RequestParam(value="author") String author, @RequestParam(value="year") String year, @RequestParam(value="isbn") String isbn, @RequestParam(value="price") String price, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("author", author);
		model.addAttribute("year", year);
		model.addAttribute("isbn", isbn);
		model.addAttribute("price", price);
		return "thyme";
	}
	
	  @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }
	  
	  /*@RequestMapping(value="/booklist")
	    public String logout() {	
	        return "redirect:/login?logout";
	    }*/
	  
	
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    } 
	//REST all books
	@RequestMapping(value="books", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	//REST book by id
	@RequestMapping(value="book/{id}", method=RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
		return repository.findOne(bookId);
	}
	
	  @RequestMapping(value = "/add")
	    public String addStudent(Model model){
	    	model.addAttribute("book", new Book());
	        return "addbook";
	    } 
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.delete(bookId);
        return "redirect:../booklist";
    }     

}

