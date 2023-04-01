package com.ineuron.dto;

import java.sql.Date;

public class IssuedBooks {

	private String author;
	private String title;
	private String category;
	private Date issue_date;

	public IssuedBooks(String author, String title, String category, Date issue_date) {
		super();
		this.author = author;
		this.title = title;
		this.category = category;
		this.issue_date = issue_date;
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

	public Date getIssue_date() {
		return issue_date;
	}

	@Override
	public String toString() {
		return "IssuedBooks [author=" + author + ", title=" + title + ", category=" + category + ", issue_date="
				+ issue_date + "]";
	}

}
