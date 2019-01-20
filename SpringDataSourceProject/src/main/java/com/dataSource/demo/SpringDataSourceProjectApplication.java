package com.dataSource.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.domain.Post;
import com.repository.PostRepository;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EntityScan({"com.domain"})
@ComponentScan({"com.repository"})
@EnableJpaRepositories({"com.repository"})
public class SpringDataSourceProjectApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(SpringDataSourceProjectApplication.class);
	
	@Autowired
	PostRepository postRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataSourceProjectApplication.class, args);
	}
	
	@PostConstruct
	void seePost() {
		logger.info("seePost method has been called");
		for(Post post : postRepository.findAll()) {
			logger.info(post.toString());
		}
	}

}

