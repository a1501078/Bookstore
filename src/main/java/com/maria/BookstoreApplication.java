package com.maria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maria.domain.Book;
import com.maria.domain.BookRepository;
import com.maria.domain.User;
import com.maria.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, UserRepository userrepository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "123123123-21", 13.00));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "124124124-31", 12.00));	
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user1@user.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "user2@user.com", "ADMIN");
			User user3 = new User("superuser", "$2a$04$DcJNFiRCdGYhR8c51E.A0.3M.vwGVDwQgL3goq8FoR.renz90QT0e", "user3@user.com", "USER");
			userrepository.save(user1);
			userrepository.save(user2);
			userrepository.save(user3);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

