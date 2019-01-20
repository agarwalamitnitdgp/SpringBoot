package com.mongodb.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.service.PostService;

@Controller
@RequestMapping("/posts")
@ComponentScan({"com.dataSource"})
public class PostController {

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping("/lists")
	public String listPosts(Model model) {
		model.addAttribute("posts", postService.list());
		return "post/list";
	}
	
	@RequestMapping("/view/{slug}")
	public String view(@PathParam(value="slug") String slug,Model model) {
		model.addAttribute("post", postService.getBySlug(slug));
		return "post/view";
	}
}
