package com.maria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maria.domain.Book;
import com.maria.domain.BookRepository;

//import com.maria.domain.BookstoreApplication;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "123123123-21", 13.00));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "124124124-31", 12.00));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

