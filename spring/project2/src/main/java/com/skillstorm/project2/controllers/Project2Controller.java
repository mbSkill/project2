package com.skillstorm.project2.controllers;
import com.skillstorm.project2.device.DeviceService;
import com.skillstorm.project2.plan.Plan;
import com.skillstorm.project2.plan.PlanService;
import com.skillstorm.project2.user.UserService;
import com.skillstorm.project2.userPlan.UserPlan;
import com.skillstorm.project2.userPlan.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Project2Controller {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private PlanService planService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserPlanService userPlanService;

    public Project2Controller() {
        System.out.println("controller created!");
    }

    // Users should be able to sign into their account, and only be able to manage that account
    //User A should not be able to view/ edit user B’s account
    @GetMapping("/userplans")
    // Users should be able to see a breakdown of their monthly bill based on their plans
    public ResponseEntity<List<UserPlan>> getUserPlans() {
        System.out.println("GET user plans");
        return new ResponseEntity<List<UserPlan>>(userPlanService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/plans")
    // Users should be able to see a breakdown of their monthly bill based on their plans
    public ResponseEntity<List<Plan>> getPlans() {
        System.out.println("GET plans");
        return new ResponseEntity<List<UserPlan>>(planService.findAll(), HttpStatus.OK);
    }
}
