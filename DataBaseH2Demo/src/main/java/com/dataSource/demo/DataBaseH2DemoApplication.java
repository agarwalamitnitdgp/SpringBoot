package com.dataSource.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.dataSource"})
@EnableJpaRepositories("com.dataSource")
@ComponentScan({"com.dataSource"})
public class DataBaseH2DemoApplication {

	/*private final static Logger logger = LoggerFactory.getLogger(DataBaseH2DemoApplication.class);
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	DataLoader dataLoader;*/
	
	public static void main(String[] args) {
		SpringApplication.run(DataBaseH2DemoApplication.class, args);
	}

	/*@PostConstruct
	void seePosts() {
		logger.info("Hello we are in seePosts method");
		for (Post post : postRepository.findAll()) {
			logger.info(post.toString());
		}
	}*/
}

