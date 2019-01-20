package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
