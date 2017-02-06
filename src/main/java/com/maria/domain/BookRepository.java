package com.maria.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maria.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	 List<Book> findAll();

}
