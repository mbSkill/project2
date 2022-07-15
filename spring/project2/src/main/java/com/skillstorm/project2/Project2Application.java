package com.skillstorm.project2;

import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.user.UserRepository;
import com.skillstorm.project2.user.UserService;
import com.skillstorm.project2.userPlan.UserPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project2Application {
	@Autowired
	UserRepository userRepo;
	@Autowired
	DeviceRepository deviceRepo;
	@Autowired
	UserPlanRepository userPlanRepo;


	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

	@Bean
	CommandLineRunner runner (UserRepository repo){

		 return (args ->  userPlanRepo.findAll().forEach(System.out::println));
	}
}
