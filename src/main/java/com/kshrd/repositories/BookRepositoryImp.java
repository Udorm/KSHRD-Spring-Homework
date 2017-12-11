//package com.kshrd.repositories;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.github.javafaker.Faker;
//import com.kshrd.models.Book;
//
//@Repository
//public class BookRepositoryImp implements BookRepository{
//	private List<Book> books = new ArrayList<Book>();
//	
//	Faker faker = new Faker();
//	
//	public BookRepositoryImp() {
//		
//		for(int i = 1; i <= 10; i++) {
//			String fTitle = faker.book().title();
//			String fAuthor = faker.book().author();
//			int fPage = Integer.parseInt(faker.number().digits(2));
//			String fCoverImage = "https://picsum.photos/200/260/?random";//faker.internet().image(25, 35, false, null);
//			String fPublishDate = faker.date().birthday().toString();
//			books.add(new Book(i, fTitle, fPublishDate, fAuthor, fPage, fCoverImage));
//		}
//	}
//	
//	@Override
//	public List<Book> findAll() {
//		// TODO Auto-generated method stub
//		return books;
//	}
//
//	@Override
//	public Book findById(int id) {
//		// TODO Auto-generated method stub
//		for(Book book : books) {
//			if (book.getId() == id) {
//				return book;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public Boolean save(Book book) {
//		// TODO Auto-generated method stub
//		return books.add(book);
//	}
//
//	@Override
//	public Boolean update(int id, Book book) {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < bookCount(); i++) {
//			if (books.get(i).getId() == id) {
//				books.set(i, book);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public Boolean delete(int id) {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < bookCount(); i++) {
//			if (books.get(i).getId() == id) {
//				books.remove(i);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public int bookCount() {
//		// TODO Auto-generated method stub
//		return books.size();
//	}
//}
