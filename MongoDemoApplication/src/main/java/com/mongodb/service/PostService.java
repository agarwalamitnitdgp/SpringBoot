package com.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.domain.Post;
import com.mongodb.repository.PostRepository;


@Service
public class PostService {

	private PostRepository postRepository;
	
	
	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post getLatestPost() {
		return postRepository.findFirstByOrderByPostedOnDesc();
	}

	public List<Post> list() {
		return postRepository.findAllByOrderByPostedOnDesc();
	}

	public Post getBySlug(String slug) {
		return postRepository.findBySlug(slug);
	}
}
