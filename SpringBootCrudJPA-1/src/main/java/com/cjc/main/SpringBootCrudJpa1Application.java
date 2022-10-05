package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class SpringBootCrudJpa1Application {

	public static void main(String[] args) 
	{
		System.out.println("This is Spring Boot JPA Application");
		SpringApplication.run(SpringBootCrudJpa1Application.class, args);
	}

}
