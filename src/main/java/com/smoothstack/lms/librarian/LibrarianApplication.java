package com.smoothstack.lms.librarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smoothstack.lms.librarian.service.LibraryBranchService;

@SpringBootApplication
public class LibrarianApplication {

	public static void main(String[] args) {
		LibraryBranchService libraryBranchService= new LibraryBranchService();
		System.out.println(libraryBranchService.getLibraryBranchById(1));
		SpringApplication.run(LibrarianApplication.class, args);
	}

}
