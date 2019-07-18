package com.smoothstack.lms.librarian.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.smoothstack.lms.librarian.model.LibraryBranch;
@Component
public class LibraryBranchDao {
	public final static String URL = "jdbc:mysql://localhost:3306/LMS?useSSL=false&autoReconnect=true&serverTimezone=UTC";
	public final static String USER = "root";
	public final static String PASSWORD = "root";
	
	public LibraryBranch getLibraryBranchByID(int libraryBranchID) {
		String sql = "SELECT * FROM tbl_library_branch where branchId=?";
		LibraryBranch tempLibraryBranch = new LibraryBranch();
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement prepareStatement = conn.prepareStatement(sql)){
			prepareStatement.setInt(1, libraryBranchID); 
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String address = resultSet.getString(3);
				tempLibraryBranch.setBranchID(id);
				tempLibraryBranch.setBranchName(name);
				tempLibraryBranch.setBranchAddress(address);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempLibraryBranch;
	}

	public LibraryBranch updateLibraryBranchName(LibraryBranch newLibraryBranchDetails) {
		// TODO Auto-generated method stub
		int libraryBranchID =  newLibraryBranchDetails.getBranchID();
		String newLibraryBranchName = newLibraryBranchDetails.getBranchName();
		
		String sql = "update tbl_library_branch set branchName = ? "
				+ "where branchId = ?";
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement prepareStatement = conn.prepareStatement(sql)){

				prepareStatement.setString(1, newLibraryBranchName);
				prepareStatement.setInt(2, libraryBranchID);
				//execute
				prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newLibraryBranchDetails;
	}

}
