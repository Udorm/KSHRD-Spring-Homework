package com.kshrd.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kshrd.models.Book;

@Repository
public interface MyBatisBookRepository {
	
	@Select("SELECT id, title, publishDate, author, page, coverImage FROM books ORDER BY title")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "publishers", column = "id", many = @Many(select = "com.kshrd.repositories.PublisherRepository.findPublisherByBookId"))
	})
	public List<Book> findAll();
	
	@Select("SELECT id, title, publishDate, author, page, coverImage FROM books WHERE id = #{id}")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "publishers", column = "id", many = @Many(select = "com.kshrd.repositories.PublisherRepository.findPublisherByBookId"))
	})
	public Book findById(int id);
	
	@Select("SELECT id, title, publishDate, author, page, coverImage FROM books WHERE title||author LIKE '%'||#{searchText}||'%'")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "publishers", column = "id", many = @Many(select = "com.kshrd.repository.PublisherRepository.findPublisherByBookId"))
	})
	public List<Book> findByText(@Param("searchText") String str);
	
	@Insert("INSERT INTO books (title, publishDate, author, page, coverImage) VALUES(#{title},#{publishDate},#{author},#{page},#{coverImage})")
	/*@SelectKey(before = false, 
			   statement = "SELECT LAST_INSERT_ID()", 
			   keyColumn = "id", 
			   keyProperty = "id", 
			   resultType = int.class)*/
	@SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=int.class)
	public Boolean save(Book book);
	
	@Insert("INSERT INTO BOOK_PUBLISHER (BOOK_ID, PUBLISHER_ID) VALUES (#{book_id}, #{publisher_id})")
	public boolean saveBookPublisher(@Param("book_id") int bookId, @Param("publisher_id") int publisherID);
	
	@Update("UPDATE books SET title = #{book.title}, publishDate = #{book.publishDate}, author = #{book.author}, page = #{book.page}, coverImage = #{book.coverImage} WHERE id = #{id}")
	public Boolean update(@Param("id") int id, @Param("book") Book book);
	
	@Delete("DELETE FROM books WHERE id = #{id}")
	public Boolean delete(int id);
	
	@Delete("DELETE FROM book_publisher WHERE book_id = #{id}")
	public Boolean deletePublisherByBookId(int id);
	
	@Select("SELECT Count(id) FROM books")
	public int bookCount();
}
