package com.kshrd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.models.Book;
import com.kshrd.repositories.MyBatisBookRepository;

@Service
public class BookServiceImp implements BookService{
	@Autowired
	//BookRepository bookRepository;
	MyBatisBookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public Boolean save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public Boolean update(int id, Book book) {
		// TODO Auto-generated method stub
		return bookRepository.update(id, book);
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		return bookRepository.delete(id);
	}

	@Override
	public int bookCount() {
		// TODO Auto-generated method stub
		return bookRepository.bookCount();
	}
	
	@Override
	public int nextID() {
		return bookCount() + 1;
	}

	@Override
	public List<Book> findByText(String searchText) {
		// TODO Auto-generated method stub
		return bookRepository.findByText(searchText);
	}
}
