package com.smoothstack.lms.librarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LibrarianApplication {

	public static void main(String[] args) {
		//LibraryBranchService libraryBranchService= new LibraryBranchService();
		//System.out.println(libraryBranchService.getLibraryBranchById(1));
		SpringApplication.run(LibrarianApplication.class, args);
	}

}
