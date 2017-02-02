package com.maria.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@RequestMapping(value="/index")
	public String book(@RequestParam(value="title") String title, @RequestParam(value="author") String author, @RequestParam(value="year") String year, @RequestParam(value="isbn") String isbn, @RequestParam(value="price") String price, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("author", author);
		model.addAttribute("year", year);
		model.addAttribute("isbn", isbn);
		model.addAttribute("price", price);
		return "thyme";
	}
}
