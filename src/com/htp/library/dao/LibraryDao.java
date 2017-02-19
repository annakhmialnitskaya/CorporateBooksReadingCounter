package com.htp.library.dao;

import java.util.List;

import com.htp.library.dao.dto.BookEmployeeDTO;

public interface LibraryDao {

	List<BookEmployeeDTO> getListEmployeesWithMoreThanOneBook() throws LibraryDaoException;

	List<BookEmployeeDTO> getListEmployeesWithLessThanOrEqualTwoBook() throws LibraryDaoException;

	void renameBook(String oldBrief, String newBrief) throws LibraryDaoException;

	void fillBookEmployeeTable() throws LibraryDaoException;
}
