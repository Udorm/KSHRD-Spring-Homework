package com.kshrd.models;

public class Publisher {
	private int id;
	private String publisher;
	public Publisher(int id, String publisher) {
		super();
		this.id = id;
		this.publisher = publisher;
	}
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publisher(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", publisher=" + publisher + "]";
	}
	
}
