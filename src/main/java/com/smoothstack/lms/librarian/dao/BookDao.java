package com.smoothstack.lms.librarian.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.librarian.model.Book;



public interface BookDao extends JpaRepository<Book, Integer> {
	
}
