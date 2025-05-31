package org.learnings.springboot.SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
Spring Boot is an opinionated framework
everything is configurable
contains reference to parent pom which contains all the standard dependencies
Spring Boot supports Annotation based configuration
 */
@SpringBootApplication

public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

}