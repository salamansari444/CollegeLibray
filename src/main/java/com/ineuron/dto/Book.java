package com.ineuron.dto;

public class Book {

	private Integer bid;
	private String author;
	private String title;
	private String category;
	private Integer totalBooks;
	private Integer presentBooks;

	public Book(Integer bid, String author, String title, String category, Integer totalBooks, Integer presentBooks) {
		super();
		this.bid = bid;
		this.author = author;
		this.title = title;
		this.category = category;
		this.totalBooks = totalBooks;
		this.presentBooks = presentBooks;
	}

	public Book() {
		super();
	}

	public Book(String author, String title, String category) {
		this.author = author;
		this.title = title;
		this.category = category;
	}

	public Integer getBid() {
		return bid;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public Integer getTotalBooks() {
		return totalBooks;
	}

	public Integer getPresentBooks() {
		return presentBooks;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", author=" + author + ", title=" + title + ", category=" + category
				+ ", totalBooks=" + totalBooks + ", presentBooks=" + presentBooks + "]";
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setTotalBooks(Integer totalBooks) {
		this.totalBooks = totalBooks;
	}

	public void setPresentBooks(Integer presentBooks) {
		this.presentBooks = presentBooks;
	}

}
