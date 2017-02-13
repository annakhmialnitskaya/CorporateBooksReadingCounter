package com.htp.library.dao;

import com.htp.library.domain.Book;

public interface BookDao {

	void createBook(Book book) throws LibraryDaoException;

	Book getBookById(int id) throws LibraryDaoException;

	void updateBook(Book book) throws LibraryDaoException;

	void deleteBookById(int id) throws LibraryDaoException;

}
