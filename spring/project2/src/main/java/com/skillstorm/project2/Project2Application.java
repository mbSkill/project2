package com.skillstorm.project2;

import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.plan.PlanService;
import com.skillstorm.project2.userPlan.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		// users can add and remove devices from their account

	}

}
