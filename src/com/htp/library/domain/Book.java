package com.htp.library.domain;

public class Book {

	private int id;
	private String author;
	private String brief;
	private int datePublishing;

	public Book(int id, String author, String brief, int datePublishing) {
		super();
		this.id = id;
		this.author = author;
		this.brief = brief;
		this.datePublishing = datePublishing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getDatePublishing() {
		return datePublishing;
	}

	public void setDatePublishing(int datePublishing) {
		this.datePublishing = datePublishing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + datePublishing;
		result = prime * result + id;
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (datePublishing != other.datePublishing)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", brief=" + brief + ", datePublishing=" + datePublishing
				+ "]";
	}

}
