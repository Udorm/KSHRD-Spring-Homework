package com.kshrd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.models.Book;
import com.kshrd.models.Publisher;
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
		boolean status = bookRepository.save(book);
		System.out.println(book.toString());
		if (status) {
			//Save book_publisher
			for(Publisher publisher : book.getPublishers()) {
				bookRepository.saveBookPublisher(book.getId(), publisher.getId());
			}
			System.out.println("Saved in book_publisher : " + book.getPublishers().toString());
		}else {
			System.out.println("Save fials in book_publisher : " + book.getPublishers().toString());
			return false;
		}
		return status;
	}

	@Override
	public Boolean update(int id, Book book) {
		boolean status = false;
		if (bookRepository.deletePublisherByBookId(id)) {
			if (bookRepository.update(id, book)) {
				for(Publisher publisher : book.getPublishers()) {
					bookRepository.saveBookPublisher(book.getId(), publisher.getId());
				}
				return true;
			}
		}
		return status;
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
