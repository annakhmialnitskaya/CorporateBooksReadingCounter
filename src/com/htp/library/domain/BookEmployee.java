package com.htp.library.domain;

public class BookEmployee {

	private int idBook;
	private int idEmployee;
	
	public BookEmployee(int idBook, int idEmployee) {
		super();
		this.idBook = idBook;
		this.idEmployee = idEmployee;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBook;
		result = prime * result + idEmployee;
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
		BookEmployee other = (BookEmployee) obj;
		if (idBook != other.idBook)
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookEmployee [idBook=" + idBook + ", idEmployee=" + idEmployee + "]";
	}
}
