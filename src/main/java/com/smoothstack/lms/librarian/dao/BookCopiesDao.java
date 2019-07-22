package com.smoothstack.lms.librarian.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.lms.librarian.model.BookCopies;
import com.smoothstack.lms.librarian.model.BookCopiesID;


public interface BookCopiesDao extends JpaRepository<BookCopies, BookCopiesID>{
	
	//@Query(value = "SELECT * FROM tbl_book_copies WHERE branchId = ?1", nativeQuery = true)
    public List<BookCopies> findByid_libraryBranch_branchID(Integer branchID);
	//public Optional<List<BookCopies>> findByBranchId(Integer branchId);

}
