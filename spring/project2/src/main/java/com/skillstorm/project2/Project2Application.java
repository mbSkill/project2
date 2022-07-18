package com.skillstorm.project2;

import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.plan.PlanRepository;
import com.skillstorm.project2.user.UserRepository;
import com.skillstorm.project2.plan.PlanService;
import com.skillstorm.project2.userPlan.UserPlanRepository;
import com.skillstorm.project2.userPlan.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Project2Application {
	@Autowired
	UserPlanService userPlanService;
	DeviceRepository deviceRepository;

	@Autowired
	PlanService planService;

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

	@Bean
	CommandLineRunner runner (UserRepository repo){
		List<Integer> ids = Arrays.asList(4, 5, 9);
		System.out.println("-------------------plans begin");
		System.out.println("-------------------plans end");
		System.out.println(deviceRepository.findAll());


		return (args -> deviceRepository.findAll());
	}

}
