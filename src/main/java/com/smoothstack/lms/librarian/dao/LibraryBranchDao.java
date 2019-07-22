package com.smoothstack.lms.librarian.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.librarian.model.LibraryBranch;


public interface LibraryBranchDao extends JpaRepository<LibraryBranch, Integer> {

}
