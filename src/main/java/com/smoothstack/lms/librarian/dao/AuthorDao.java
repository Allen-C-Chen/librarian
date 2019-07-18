package com.smoothstack.lms.librarian.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.smoothstack.lms.librarian.model.Author;
@Component
public class AuthorDao {
	public final static String URL = "jdbc:mysql://localhost:3306/LMS?useSSL=false&autoReconnect=true&serverTimezone=UTC";
	public final static String USER = "root";
	public final static String PASSWORD = "root";
	
	public ArrayList<Author> getAllAuthors() {
		ArrayList<Author> authors = new ArrayList<Author>();
		String sql = "SELECT * FROM tbl_author;";
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement prepareStatement = conn.prepareStatement(sql)){
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				Author tempAuthor = new Author();
				tempAuthor.setAuthorId(resultSet.getInt(1));
				tempAuthor.setAuthorName(resultSet.getString(2));
				authors.add(tempAuthor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authors;
	}
}
