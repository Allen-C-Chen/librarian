package com.smoothstack.lms.librarian.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class BookCopiesID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@ManyToOne
	@JoinColumn (name = "bookId")
	private Book book;
	@NotNull
	@ManyToOne
	@JoinColumn (name = "branchId")
	private LibraryBranch libraryBranch;
	
	public BookCopiesID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookCopiesID(@NotNull Book book, @NotNull LibraryBranch libraryBranch) {
		super();
		this.book = book;
		this.libraryBranch = libraryBranch;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LibraryBranch getLibraryBranch() {
		return libraryBranch;
	}
	public void setLibraryBranch(LibraryBranch libraryBranch) {
		this.libraryBranch = libraryBranch;
	}

}
