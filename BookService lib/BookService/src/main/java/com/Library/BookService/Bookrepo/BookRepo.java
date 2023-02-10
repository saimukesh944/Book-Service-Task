package com.Library.BookService.Bookrepo;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.Library.BookService.model.Book;



@Repository
public interface BookRepo extends MongoRepository<Book, String>{

	//Book findByAuthor(String author);
	
	
	//Book findByGenre(String genre);




	Book findByBookTitle(String bookTitle);


	List<Book> findAllByGenre(String genre);


	List<Book> findAllByAuthor(String author);


	


}
