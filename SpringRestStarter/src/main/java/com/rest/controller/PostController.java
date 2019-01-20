package com.rest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.Post;
import com.rest.exception.PostNotFoundException;
import com.rest.service.PostService;

@RestController
@RequestMapping("/posts")
@ComponentScan({"com.rest"})
public class PostController {

	private PostService postService;

	@Autowired
	public PostController(PostService postService){
		this.postService = postService;
	}	


	@RequestMapping( value = "/", method = RequestMethod.GET )
	//	@ResponseBody      /* This is not required when we add RestController annotation */
	public Iterable<Post> list(){
		return postService.list();
	}

	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Post create(@RequestBody Post post){
		return postService.create(post);
	}

	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Post read(@PathVariable(value="id") long id) throws PostNotFoundException{

		Post post = postService.read(id);
		if(post == null) {
			throw new PostNotFoundException("Post with Id : "+ id + " is not found.");
		}
		return post;
	}

	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public Post update(@PathVariable(value="id") long id, @RequestBody Post post){
		return postService.update(id,post);
	}

	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	public void delete(@PathVariable(value="id") int id){
		postService.delete(id);
	}	

	@ExceptionHandler(PostNotFoundException.class)
	public void handlePostNotFound(PostNotFoundException exception,HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
}
