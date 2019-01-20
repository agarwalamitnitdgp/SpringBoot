package com.example.configurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

	@Bean(name= "dataSource")
	@Profile("development")
	DataSource developmentDataSource() {
		return new DataSource("my-development-url",9999);
	}
	
	@Bean(name= "dataSource")
	@Profile("production")
	DataSource productionDataSource() {
		return new DataSource("my-production-url",9999);
	}
}
