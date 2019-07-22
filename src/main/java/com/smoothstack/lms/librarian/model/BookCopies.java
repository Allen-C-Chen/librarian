package com.smoothstack.lms.librarian.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_copies")
public class BookCopies {
	@EmbeddedId
	private BookCopiesID id;	
    @Column(name = "noOfCopies")
	private Integer noOfCopies;
	public BookCopiesID getBookCopiesID() {
		return id;
	}
	public void setBookCopiesID(BookCopiesID bookCopiesID) {
		this.id = bookCopiesID;
	}
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
    
}
