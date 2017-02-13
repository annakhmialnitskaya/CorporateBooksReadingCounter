package com.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.htp.library.dao.BookDao;
import com.htp.library.dao.LibraryDaoException;
import com.htp.library.domain.Book;

public class BookDaoImpl implements BookDao {

	private static final String QUERY_DELETE = "DELETE FROM book WHERE id =? ";
	private static final String QUERY_SELECT = "SELECT brief, publish_year, author FROM book WHERE id=?";
	private static final String QUERY_INSERT = "INSERT INTO book (`id`, `brief`, `publish_year`, `author`) VALUES (?,?,?,? )";
	private static final String QUERY_UPDATE = "UPDATE book SET brief=?, publish_year=?, author=? WHERE id = ?";

	@Override
	public void createBook(Book book) throws LibraryDaoException {
		try (Connection dbConnection = LibraryDaoImpl.getDBConnection();
				PreparedStatement statement = dbConnection.prepareStatement(QUERY_INSERT)) {
			statement.setInt(1, book.getId());
			statement.setString(2, book.getBrief());
			statement.setInt(3, book.getDatePublishing());
			statement.setString(4, book.getAuthor());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new LibraryDaoException("Exception with DB!", e);
		}
	}

	@Override
	public Book getBookById(int id) throws LibraryDaoException {
		Book book = null;
		try (Connection dbConnection = LibraryDaoImpl.getDBConnection();
				PreparedStatement statement = dbConnection.prepareStatement(QUERY_SELECT)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String brief = rs.getString(1);
				int datePublishing = rs.getInt(2);
				String author = rs.getString(3);
				book = new Book(id, author, brief, datePublishing);
			}
		} catch (SQLException e) {
			throw new LibraryDaoException("Exception with DB!", e);
		}
		return book;
	}

	@Override
	public void updateBook(Book book) throws LibraryDaoException {
		try (Connection dbConnection = LibraryDaoImpl.getDBConnection();
				PreparedStatement statement = dbConnection.prepareStatement(QUERY_UPDATE)) {
			statement.setString(1, book.getBrief());
			statement.setObject(2, book.getDatePublishing());
			statement.setString(3, book.getAuthor());
			statement.setInt(4, book.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new LibraryDaoException("Exception with DB!", e);
		}
	}

	@Override
	public void deleteBookById(int id) throws LibraryDaoException {
		try (Connection dbConnection = LibraryDaoImpl.getDBConnection();
				PreparedStatement statement = dbConnection.prepareStatement(QUERY_DELETE)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new LibraryDaoException("Exception with DB!", e);
		}
	}
}
