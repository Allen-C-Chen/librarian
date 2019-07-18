package com.smoothstack.lms.librarian.service;

import com.smoothstack.lms.librarian.dao.LibraryBranchDao;
import com.smoothstack.lms.librarian.model.LibraryBranch;


public class LibraryBranchService {
	static LibraryBranchDao libraryBranchDao = new LibraryBranchDao();

	public LibraryBranch getLibraryBranchById(int libraryBranchID) {
		//return LibraryBranchDao.getLibraryBranchByID(libraryBranchID);
		return libraryBranchDao.getLibraryBranchByID(libraryBranchID);
	}
	//public void addLibraryByName

	public LibraryBranch updateLibraryBranchName(LibraryBranch newLibraryBranchDetails) {
		// TODO Auto-generated method stub
		return libraryBranchDao.updateLibraryBranchName(newLibraryBranchDetails);
	}
}

