package com.toysforshots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controller","service","config"})
public class ToysforshotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToysforshotsApplication.class, args);
	}

}

