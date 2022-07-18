package com.skillstorm.project2;

import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.user.UserRepository;
import com.skillstorm.project2.user.UserService;
import com.skillstorm.project2.userPlan.UserPlan;
import com.skillstorm.project2.userPlan.UserPlanRepository;
import com.skillstorm.project2.userPlan.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class Project2Application {
	@Autowired
	UserPlanService userPlanService;


	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

//	@Bean
//	CommandLineRunner runner (UserPlanRepository userPlanRepo){
//		 return (args ->  userPlanService.addUserPlan());
//	}
}
