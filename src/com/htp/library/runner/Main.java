package com.htp.library.runner;

import com.htp.library.service.LibraryService;
import com.htp.library.service.LibraryServiceException;
import com.htp.library.service.impl.LibraryServiceImpl;

public class Main {

	public static void main(String[] args) {
		LibraryService service = new LibraryServiceImpl();
		try {
			service.getReportEmployeesWithMoreThanOneBook();
			service.getReportEmployeesWithLessThanOrEqualTwoBook();
			service.renameBook("War", "Peace!");

			/*
			 * Book book= new Book(56, "Grisha", "vodka i moloko", 2017);
			 * service.createBook(book); service.printBookById(56);
			 * book.setAuthor("Grisha123"); service.updateBook(book);
			 * service.printBookById(56); service.deleteBookById(56);
			 */
		} catch (LibraryServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}
