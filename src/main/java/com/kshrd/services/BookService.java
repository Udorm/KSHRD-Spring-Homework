package com.kshrd.services;

import java.util.List;

import com.kshrd.models.Book;

public interface BookService {
	public List<Book> findAll();
	public Book findById(int id);
	public Boolean save(Book book);
	public Boolean update(int id, Book book);
	public Boolean delete(int id);
	public int bookCount();
	public int nextID();
}
