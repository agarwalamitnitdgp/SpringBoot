package com.rest;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rest.domain.Author;
import com.rest.domain.Post;
import com.rest.respository.AuthorRepository;
import com.rest.respository.PostRepository;

@SpringBootApplication
@EntityScan({"com.rest"})
@EnableJpaRepositories({"com.rest"})
@ComponentScan({"com.rest"})
public class SpringRestStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestStarterApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
		return args -> {

			Author dv = new Author("Dan","Vega","danvega@gmail.com");
			authorRepository.save( dv );

			Post post = new Post("Spring Boot Rocks!");
			post.setSlug("spring-data-rocks");
			post.setTeaser("Post Teaser");
			post.setBody("Post Body");
			post.setPostedOn(new Date());
			post.setAuthor(dv);
			postRepository.save(post);

			Post rest = new Post("REST is what all the cool kids are doing");
			rest.setSlug("rest-is-cool");
			rest.setTeaser("REST Teaser");
			rest.setBody("REST BODY");
			rest.setPostedOn(new Date());
			rest.setAuthor(dv);
			postRepository.save(rest);

		};
	}
}

