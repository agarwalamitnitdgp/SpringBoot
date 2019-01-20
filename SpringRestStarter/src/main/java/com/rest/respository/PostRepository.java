package com.rest.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

	Post findFirstByOrderByPostedOnDesc();

	List<Post> findAllByOrderByPostedOnDesc();

	Post findBySlug(String slug);
	
	List<Post> findByTitleContaining(@Param("title") String title); //  http://localhost:8080/posts/search/findByTitleContaining?title=Spring%20Boot%20Rocks! This URL can be used for it
 
}
