package com.kshrd.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kshrd.models.Book;

@Repository
public interface MyBatisBookRepository {
	
	@Select("SELECT id, title, publishDate, author, page, coverImage FROM books ORDER BY title")
	public List<Book> findAll();
	
	@Select("SELECT id, title, publishDate, author, page, coverImage FROM books WHERE id = #{id}")
	public Book findById(int id);
	
	@Select("SELECT id, title, publishDate, author, page, coverImage FROM books WHERE title||author LIKE '%'||#{searchText}||'%'")
	public List<Book> findByText(@Param("searchText") String str);
	
	@Insert("INSERT INTO books (id, title, publishDate, author, page, coverImage) VALUES(#{id},#{title},#{publishDate},#{author},#{page},#{coverImage})")
	public Boolean save(Book book);
	
	@Update("UPDATE books SET title = #{book.title}, publishDate = #{book.publishDate}, author = #{book.author}, page = #{book.page}, coverImage = #{book.coverImage} WHERE id = #{id}")
	public Boolean update(@Param("id") int id, @Param("book") Book book);
	
	@Delete("DELETE FROM books WHERE id = #{id}")
	public Boolean delete(int id);
	
	@Select("SELECT Count(id) FROM books")
	public int bookCount();
}
