package com.htp.library.service.impl;

import java.util.List;

import com.htp.library.dao.BookDao;
import com.htp.library.dao.LibraryDao;
import com.htp.library.dao.LibraryDaoException;
import com.htp.library.dao.dto.BookEmployeeDTO;
import com.htp.library.dao.impl.BookDaoImpl;
import com.htp.library.dao.impl.LibraryDaoImpl;
import com.htp.library.domain.Book;
import com.htp.library.service.LibraryService;
import com.htp.library.service.LibraryServiceException;

public class LibraryServiceImpl implements LibraryService {

	private LibraryDao libDao = new LibraryDaoImpl();
	private BookDao bookDao = new BookDaoImpl();

	@Override
	public void getReportEmployeesWithMoreThanOneBook() throws LibraryServiceException {
		List<BookEmployeeDTO> list;
		try {
			list = libDao.getListEmployeesWithMoreThanOneBook();
		} catch (LibraryDaoException e) {
			throw new LibraryServiceException("Error in service: " + e.getMessage(), e);
		}
		printBookEmployeeList(list);
	}

	@Override
	public void getReportEmployeesWithLessThanOrEqualTwoBook() throws LibraryServiceException {
		List<BookEmployeeDTO> list;
		try {
			list = libDao.getListEmployeesWithLessThanOrEqualTwoBook();
		} catch (LibraryDaoException e) {
			throw new LibraryServiceException("Error in service: " + e.getMessage(), e);
		}
		printBookEmployeeList(list);
	}

	@Override
	public void renameBook(String oldBrief, String newBrief) throws LibraryServiceException {
		try {
			libDao.renameBook(oldBrief, newBrief);
		} catch (LibraryDaoException e) {
			throw new LibraryServiceException("Error in service: " + e.getMessage(), e);
		}
	}

	private void printBookEmployeeList(List<BookEmployeeDTO> list) {
		for (BookEmployeeDTO bookEmployeeDTO : list) {
			System.out.println(bookEmployeeDTO);
		}
		System.out.println();
	}

	@Override
	public void createBook(Book book) throws LibraryServiceException {
		try {
			bookDao.createBook(book);
			System.out.println("New book was created!");
		} catch (LibraryDaoException e) {
			throw new LibraryServiceException("Error in service: " + e.getMessage(), e);
		}
	}

	@Override
	public void printBookById(int id) throws LibraryServiceException {
		try {
			Book book = bookDao.getBookById(id);
			System.out.println(book);
		} catch (LibraryDaoException e) {
			throw new LibraryServiceException("Error in service: " + e.getMessage(), e);
		}
	}

	@Override
	public void updateBook(Book book) throws LibraryServiceException {
		try {
			bookDao.updateBook(book);
			System.out.println("Book with id=" + book.getId() + " was updated!");
		} catch (LibraryDaoException e) {
			throw new LibraryServiceException("Error in service: " + e.getMessage(), e);
		}
	}

	@Override
	public void deleteBookById(int id) throws LibraryServiceException {
		try {
			bookDao.deleteBookById(id);
			System.out.println("Book with id=" + id + " was deleted!");
		} catch (LibraryDaoException e) {
			throw new LibraryServiceException("Error in service: " + e.getMessage(), e);
		}
	}
}
