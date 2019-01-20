package com.dataSource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dataSource.service.PostService;

@Controller
@ComponentScan({"com.dataSource"})
public class Homecontroller {

	private PostService postService;
	
	@Autowired
	public Homecontroller(PostService postService) {
		this.postService = postService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("post",postService.getLatestPost());
		return "index";
	}
}
