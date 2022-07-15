package com.skillstorm.project2;

import com.skillstorm.project2.user.UserRepository;
import com.skillstorm.project2.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project2Application {
	@Autowired
	UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

	@Bean
	CommandLineRunner runner (UserRepository repo){

		 return (args ->  repo.findAll().forEach(System.out::println));
	}
}
