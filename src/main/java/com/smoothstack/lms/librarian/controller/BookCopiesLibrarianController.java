package com.smoothstack.lms.librarian.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.librarian.dao.BookCopiesDao;
import com.smoothstack.lms.librarian.dao.BookDao;
import com.smoothstack.lms.librarian.dao.LibraryBranchDao;
import com.smoothstack.lms.librarian.model.BookCopies;
import com.smoothstack.lms.librarian.model.BookCopiesID;
@RestController
@RequestMapping("/lms")
public class BookCopiesLibrarianController {
	@Autowired
	BookCopiesDao bookCopiesDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	LibraryBranchDao libraryBranchDao;
	
	@GetMapping("/bookcopies")
	public List<BookCopies> getAllBookCopies() {
		return bookCopiesDao.findAll();
	}
	@GetMapping("/librarybranch/{libBranchId}")
	public List<BookCopies> getAllBookCopiesByBranch(
			@PathVariable Integer libBranchId) {
		return bookCopiesDao.findByid_libraryBranch_branchID(libBranchId);
		//return null;
	}
	//http://localhost:8080/lms/bookcopies/librarybranch/1/book/1/addbookcopies
	@PutMapping("/librarybranch/{libBranchId}/book/{bookID}/addbookcopies")
	public ResponseEntity<BookCopies> updateBookCopies(
			@PathVariable Integer libBranchId,
			@PathVariable Integer bookID,
			@RequestBody BookCopies bookCopies) {
		System.out.println("adfasdfhi");

		if(libBranchId == null || bookID == null || bookCopies == null) {
			return new ResponseEntity<BookCopies>(HttpStatus.BAD_REQUEST);
		}
		try {
			Optional<BookCopies> newBookCopies = bookCopiesDao.findById(
					new BookCopiesID(
							bookDao.findById(bookID).get(), 
							libraryBranchDao.findById(libBranchId).get())
					);
			if(newBookCopies == null) {
				System.out.println("hi");
			    return new ResponseEntity<BookCopies>(HttpStatus.NOT_FOUND); //404
			}
			int newNoOfCopies = bookCopies.getNoOfCopies() + newBookCopies.get().getNoOfCopies();
			newBookCopies.get().setNoOfCopies(newNoOfCopies);
			bookCopiesDao.save(newBookCopies.get());
			return new ResponseEntity<BookCopies>(HttpStatus.CREATED); 
			
		}
		catch(EmptyResultDataAccessException e){
			System.out.println("hi222");

		    return new ResponseEntity<BookCopies>(HttpStatus.NOT_FOUND); //404
		}
		
	}
	
}
