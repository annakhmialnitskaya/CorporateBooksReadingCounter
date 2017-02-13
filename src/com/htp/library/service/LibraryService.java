package com.htp.library.service;

import com.htp.library.domain.Book;

public interface LibraryService {

	void getReportEmployeesWithMoreThanOneBook() throws LibraryServiceException;

	void getReportEmployeesWithLessThanOrEqualTwoBook() throws LibraryServiceException;

	void renameBook(String oldBrief, String newBrief) throws LibraryServiceException;

	void createBook(Book book) throws LibraryServiceException;

	void printBookById(int id) throws LibraryServiceException;

	void updateBook(Book book) throws LibraryServiceException;

	void deleteBookById(int id) throws LibraryServiceException;
}
