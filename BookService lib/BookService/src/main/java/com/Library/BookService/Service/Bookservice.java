package com.Library.BookService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.Library.BookService.Bookrepo.BookRepo;
import com.Library.BookService.model.Book;

@Service
public class Bookservice {
	@Autowired
	private BookRepo bookRepo;
	
	public void addBook(Book book) {
		bookRepo.save(book);
	}
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public Book getBook(String bookId) {
		return bookRepo.findById(bookId).get();
	}
	public void deleteBook(String bookId) {
		bookRepo.deleteById(bookId);
	}
	public Book updateBook(Book book, String bookId) throws NotFoundException{
	if(book.getBookId()==null) {
		throw new NotFoundException();
	}
	Optional<Book> optionallBook = bookRepo.findById(book.getBookId());
	if(!optionallBook.isPresent()) {
		throw new NotFoundException();
	}
	Book books= optionallBook.get();
    books.setBookTitle(book.getBookTitle());
	
	return bookRepo.save(books);
	
	
	
}
	public Book getBookbyTitle(String bookTitle) {
		return bookRepo.findByBookTitle(bookTitle);
	}
//	public Book getBookbyAuthor(String author) {
//		return bookRepo.findByAuthor(author);
//	}
	public List<Book> getBookbyAuthor(String author){
		return bookRepo.findAllByAuthor(author);
	}
//	public List<Book> getBookbyAuthor(String author) {
//	    Author author = new author(author);
//
//	    return allBooks.stream()
//	            .filter(m -> m.getBook().contains(author))
//	            .collect(Collectors.toList());
	
	
//	public Book getBookbyGenre(String genre) {
//		// TODO Auto-generated method stub
//		return bookRepo.findByGenre(genre);
//	}
	public List<Book> getAllBooksbyGenre(String genre) {
		// TODO Auto-generated method stub
		return bookRepo.findAllByGenre(genre);
	
	}
	
		
}
