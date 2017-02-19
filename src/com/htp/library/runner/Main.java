package com.htp.library.runner;

import com.htp.library.service.LibraryService;
import com.htp.library.service.LibraryServiceException;
import com.htp.library.service.impl.LibraryServiceImpl;

public class Main {

	public static void main(String[] args) {
		LibraryService service = new LibraryServiceImpl();
		try {
			service.fillBookEmployeeTable();
			service.getReportEmployeesWithMoreThanOneBook();
			service.getReportEmployeesWithLessThanOrEqualTwoBook();
			service.renameBook("����� � ���", "����� � ���.�����");
		} catch (LibraryServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}
