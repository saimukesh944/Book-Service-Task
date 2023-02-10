package com.Library.BookService.model;

import org.springframework.data.annotation.Id;

public class Book {
	@Id
	private String bookId;
	private String bookTitle;
	private String genre;
	private String author;
	
	public Book(String bookId, String bookTitle, String genre, String author) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.genre = genre;
		this.author = author;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
