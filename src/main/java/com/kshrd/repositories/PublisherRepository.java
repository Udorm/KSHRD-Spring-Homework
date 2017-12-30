package com.kshrd.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.models.Publisher;

@Repository
public interface PublisherRepository {
	
	@Select("select p.id, p.publisher from publishers p")
	public List<Publisher> findAll();
	
	@Select("select p.id, p.publisher from publishers p inner join book_publisher bp on p.id = bp.publisher_id where bp.book_id=#{id}")
	public List<Publisher> findPublisherByBookId(int id);
}
