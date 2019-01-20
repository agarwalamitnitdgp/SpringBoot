package com.dataSource.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataSource.bean.Author;
import com.dataSource.bean.Post;
import com.dataSource.repository.AuthorRepository;
import com.dataSource.repository.PostRepository;

@Service
public class DataLoader {

	private PostRepository postRepository;
	private AuthorRepository authorRepository;

	@Autowired
	public DataLoader(PostRepository postRepository,AuthorRepository authorRepository) {
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}

	@PostConstruct
	public void LoadData() {
		//Create an author
		Author author = new Author("Sumit", "Agarwal");
		authorRepository.save(author);

		//Create a post
		Post post = new Post("Data Loader Spring is rocking");
		post.setBody("Our body is rocking");
		post.setPostedOn(new Date());
		post.setAuthor(author);
		postRepository.save(post);
	}

}
