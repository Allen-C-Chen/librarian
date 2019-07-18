package com.smoothstack.lms.librarian.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.librarian.model.Author;
import com.smoothstack.lms.librarian.service.AuthorService;

@RestController
public class AuthorController {
	AuthorService authorService = new AuthorService();
	@RequestMapping(path = "/lms/admin/author")
	ArrayList<Author> getAuthor () {
		return authorService.getAllAuthors();
		//testing
	}
}
