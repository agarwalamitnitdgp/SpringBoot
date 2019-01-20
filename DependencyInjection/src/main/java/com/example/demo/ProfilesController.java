package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilesController {

	@Value("${spring.profiles.active}")
	private String environment;
	
	@Value("${msg}")
	private String msg;
	
	@RequestMapping("profiles")
	private String Home() {
		return environment;
	}
	
	@RequestMapping("environemntProperties")
	private String environementProperties() {
		return msg;
	}
}
