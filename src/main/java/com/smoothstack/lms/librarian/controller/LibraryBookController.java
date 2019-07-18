package com.smoothstack.lms.librarian.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smoothstack.lms.librarian.model.LibraryBranch;
import com.smoothstack.lms.librarian.service.LibraryBranchService;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/lms/librarian")
@RestController
public class LibraryBookController {
	LibraryBranchService libraryBranchService = new LibraryBranchService();
	
//	@RequestMapping(path = "/lms/librarian/librarybranch/{libraryBranchId}",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})	
//	public ResponseEntity<LibraryBranch> getLibraryBranchByID (@PathVariable int libraryBranchId) {
//		LibraryBranch newLibraryBranch = new LibraryBranch();
//		newLibraryBranch = libraryBranchService.getLibraryBranchById(libraryBranchId);
//		if(newLibraryBranch == null) {
//			System.out.println("HI YOU ARE NOT FOUND");
//			
//			return new ResponseEntity<LibraryBranch>(HttpStatus.NOT_FOUND);
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(newLibraryBranch);
//	}
	
//	@RequestMapping(path = "/lms/librarian/librarybranch/{libraryBranchId}",
//			produces = {
//					MediaType.APPLICATION_JSON_VALUE
//			})
//	String getLibraryBranchByID (@PathVariable int libraryBranchId) {	
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(libraryBranchService.getLibraryBranchById(libraryBranchId)));
//		return gson.toJson(libraryBranchService.getLibraryBranchById(libraryBranchId));
//	}
	
	@RequestMapping(path = "/librarybranch/{libraryBranchId}",
			produces = {
					MediaType.APPLICATION_JSON_VALUE
			})
	ResponseEntity<String> getLibraryBranchByID (@PathVariable int libraryBranchId) {	
		Gson gson = new Gson();
		LibraryBranch newLibraryBranch =  libraryBranchService.getLibraryBranchById(libraryBranchId);
		String response = gson.toJson(newLibraryBranch);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = 	"/update/{libraryBranchId}",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE
			},
			produces = {
					MediaType.APPLICATION_JSON_VALUE //media type
			})
	public LibraryBranch updateLibraryBranch (@PathVariable int libraryBranchId, @RequestBody LibraryBranch newLibraryBranchDetails) {
		LibraryBranch newLibrayBranch = libraryBranchService.updateLibraryBranchName(newLibraryBranchDetails);
		return newLibrayBranch;
	}
	
	@RequestMapping(value = "/controller", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity sendViaResponseEntity() {
	    return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}
}
