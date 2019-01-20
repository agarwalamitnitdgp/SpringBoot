package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.configurationProperties.MyAppConfig;
import com.example.foo.User;

@ComponentScan({"com.example.demo","com.example.foo","com.example.configurationProperties"})
@SpringBootApplication
@EnableConfigurationProperties
public class DependencyInjectionApplication {

	@Bean
	public User user() {
		return new User("Amit","Agarwal");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String name : beanNames) {
			System.out.println("Name "+name);
		}
		System.out.println(ctx.getBean("user").toString());
		
		MyAppConfig config = (MyAppConfig) ctx.getBean("myAppConfig");
		System.out.println("config "+config.toString());
		
		System.out.println(ctx.getBean("dataSource").toString());
	}

}

