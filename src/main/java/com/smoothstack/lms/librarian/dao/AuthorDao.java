package com.smoothstack.lms.librarian.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.lms.librarian.model.Author;


@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
	
}
