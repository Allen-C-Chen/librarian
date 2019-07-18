package com.smoothstack.lms.librarian.service;

import java.util.ArrayList;

import com.smoothstack.lms.librarian.dao.AuthorDao;
import com.smoothstack.lms.librarian.model.Author;

public class AuthorService {
	AuthorDao authorDao = new AuthorDao();
	
	public ArrayList<Author> getAllAuthors(){
		return authorDao.getAllAuthors();
	}
}
