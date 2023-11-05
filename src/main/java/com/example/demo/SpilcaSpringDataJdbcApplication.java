package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"controllers","services"})
@EnableJdbcRepositories(basePackages={"repositories"})
public class SpilcaSpringDataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpilcaSpringDataJdbcApplication.class, args);
	}

}
