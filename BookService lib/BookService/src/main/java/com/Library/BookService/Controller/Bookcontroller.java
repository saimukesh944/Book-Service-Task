package com.Library.BookService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Library.BookService.Service.Bookservice;
import com.Library.BookService.model.Book;



@RestController
@RequestMapping("books")
public class Bookcontroller {
	@Autowired
	private Bookservice bookService;
	
	

	@PostMapping("/add")
	public void addDetails(@RequestBody Book book) {
	bookService.addBook(book);
	}

	@GetMapping("/list")
	public List<Book> getAllBooks() {
			return bookService.getAllBooks();
	}

	@GetMapping("getbook/{bookId}")
	public Book getBook (@PathVariable String bookId) {
			return bookService.getBook(bookId);
	}

	@DeleteMapping("delete/{bookId}")
	public void delete (@PathVariable String bookId) {
			bookService.deleteBook(bookId);
	}

	@PutMapping("/update/{bookId}")
	public Book updateBook(@RequestBody Book book , @PathVariable String bookId ) throws NotFoundException {
			return bookService.updateBook(book,bookId);
			
	}
	@GetMapping("getbookbyTitle/{bookTitle}")
	public Book getBookbyTitle (@PathVariable("bookTitle") String bookTitle) {
			return bookService.getBookbyTitle(bookTitle);
	
	}
//	@GetMapping("getbookbyAuthor/{Author}")
//	public Book getBookbyAuthor (@PathVariable String author) {
//			return bookService.getBookbyAuthor(author);
//	}
	@GetMapping("/getbooksbyAuthor/{author}")
	public List<Book> getBookbyAuthor(@PathVariable("author") String author){
			return bookService.getBookbyAuthor(author);
	}
	@GetMapping("/getbookbyGenre/{genre}")
	public List<Book> getBookbyGenre(@PathVariable("genre") String genre) {
			return bookService.getAllBooksbyGenre(genre);
	}
	
}
