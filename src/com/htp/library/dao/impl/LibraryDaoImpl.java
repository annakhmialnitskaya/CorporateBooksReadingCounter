package com.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.htp.library.dao.LibraryDao;
import com.htp.library.dao.LibraryDaoException;
import com.htp.library.dao.dto.BookEmployeeDTO;

public class LibraryDaoImpl implements LibraryDao {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/htp";
	private static final String DB_USER = "anna";
	private static final String DB_PASSWORD = "Anna2017-";
	private static final String QUERY_EMPLOYEES_MORE_THAN_ONE_BOOK = "SELECT employee.name, count(*) as c FROM mm_employee_book join employee on employee.id=mm_employee_book.employee_id group by mm_employee_book.employee_id having c>1 order by c";
	private static final String QUERY_EMPLOYEES_LESS_THAN_TWO_BOOKS = "SELECT employee.name, employee.date_of_birth, count(*) as c FROM mm_employee_book join employee on employee.id=mm_employee_book.employee_id group by mm_employee_book.employee_id having c<=2 order by employee.date_of_birth, c";
	private static final String QUERY_RENAME_BOOK = "UPDATE book SET brief=? WHERE brief=?";

	@Override
	public List<BookEmployeeDTO> getListEmployeesWithMoreThanOneBook() throws LibraryDaoException {
		List<BookEmployeeDTO> resultList = new ArrayList<>();
		try (Connection dbConnection = getDBConnection();
				PreparedStatement statement = dbConnection.prepareStatement(QUERY_EMPLOYEES_MORE_THAN_ONE_BOOK)) {
			ResultSet rs = statement.executeQuery();
			BookEmployeeDTO dto;
			while (rs.next()) {
				String name = rs.getString(1);
				int numberBooks = rs.getInt(2);
				dto = new BookEmployeeDTO(name, numberBooks);
				resultList.add(dto);
			}
		} catch (SQLException e) {
			throw new LibraryDaoException("Exception with DB!", e);
		}
		return resultList;
	}

	@Override
	public List<BookEmployeeDTO> getListEmployeesWithLessThanOrEqualTwoBook() throws LibraryDaoException {
		List<BookEmployeeDTO> resultList = new ArrayList<>();
		try (Connection dbConnection = getDBConnection();
				PreparedStatement statement = dbConnection.prepareStatement(QUERY_EMPLOYEES_LESS_THAN_TWO_BOOKS)) {
			ResultSet rs = statement.executeQuery();
			BookEmployeeDTO dto;
			while (rs.next()) {
				String name = rs.getString(1);
				Date employeeDateBirth = rs.getDate(2);
				int numberBooks = rs.getInt(3);
				dto = new BookEmployeeDTO(name, employeeDateBirth, numberBooks);
				resultList.add(dto);
			}
		} catch (SQLException e) {
			throw new LibraryDaoException("Exception with DB!", e);
		}
		return resultList;
	}

	@Override
	public void renameBook(String oldBrief, String newBrief) throws LibraryDaoException {
		try (Connection dbConnection = getDBConnection();
				PreparedStatement statement = dbConnection.prepareStatement(QUERY_RENAME_BOOK)) {
			statement.setString(1, newBrief);
			statement.setString(2, oldBrief);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new LibraryDaoException("Exception with DB!", e);
		}
	}

	public static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			System.out.println("Error with DB connection!");
		}
		return dbConnection;
	}
}
