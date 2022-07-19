package com.skillstorm.project2;

import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.plan.PlanService;
import com.skillstorm.project2.user.UserRepository;
import com.skillstorm.project2.userPlan.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Project2Application {
	@Autowired
	UserPlanService userPlanService;
	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	PlanService planService;

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}
