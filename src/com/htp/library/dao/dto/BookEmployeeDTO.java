package com.htp.library.dao.dto;

import java.util.Date;

public class BookEmployeeDTO {

	private String employeeName;
	private Date employeeDateBirth;
	private int numberBooks;

	public BookEmployeeDTO(String employeeName, Date employeeDateBirth, int numberBooks) {
		super();
		this.employeeName = employeeName;
		this.employeeDateBirth = employeeDateBirth;
		this.numberBooks = numberBooks;
	}

	public BookEmployeeDTO(String employeeName, int numberBooks) {
		super();
		this.employeeName = employeeName;
		this.numberBooks = numberBooks;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getEmployeeDateBirth() {
		return employeeDateBirth;
	}

	public void setEmployeeDateBirth(Date employeeDateBirth) {
		this.employeeDateBirth = employeeDateBirth;
	}

	public int getNumberBooks() {
		return numberBooks;
	}

	public void setNumberBooks(int numberBooks) {
		this.numberBooks = numberBooks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeDateBirth == null) ? 0 : employeeDateBirth.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + numberBooks;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEmployeeDTO other = (BookEmployeeDTO) obj;
		if (employeeDateBirth == null) {
			if (other.employeeDateBirth != null)
				return false;
		} else if (!employeeDateBirth.equals(other.employeeDateBirth))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (numberBooks != other.numberBooks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(employeeName);
		if (employeeDateBirth != null) {
			sb.append(", " + employeeDateBirth);
		}
		sb.append(": ");
		sb.append(numberBooks);

		return sb.toString();
	}

}
