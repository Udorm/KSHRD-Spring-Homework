package com.kshrd.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {
	
	private int id;
	
	@NotEmpty
	@Size(min=1, max=50)
	private String title;
	
	@NotEmpty
	private String publishDate;
	
	@NotEmpty
	@Size(min=1, max=30)
	private String author;
	
	@Min(1)
	private int page;
	
	//@NotEmpty
	private String coverImage;
	
	public Book(int id, String title, String publishDate, String author, int page, String coverImage) {
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.page = page;
		this.coverImage = coverImage;
	}
	
	public Book() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author + ", page="
				+ page + ", coverImage=" + coverImage + "]";
	}
}
