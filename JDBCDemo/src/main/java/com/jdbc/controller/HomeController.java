package com.jdbc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdbc.service.PostService;

@Controller
@ComponentScan({"com.jdbc"})
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private PostService postService;
	
	@Autowired
	public HomeController(PostService postService){
		this.postService = postService;
	}
	
	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("post", postService.getLatestPost());
		System.out.println("Amit   "+postService.getLatestPost().getTitle());
		return "index";
	}
}
