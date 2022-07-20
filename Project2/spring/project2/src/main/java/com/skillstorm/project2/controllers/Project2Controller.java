package com.skillstorm.project2.controllers;
import com.skillstorm.project2.device.DeviceService;
import com.skillstorm.project2.plan.Plan;
import com.skillstorm.project2.plan.PlanService;
import com.skillstorm.project2.user.User;
import com.skillstorm.project2.user.UserService;
import com.skillstorm.project2.userPlan.UserPlan;
import com.skillstorm.project2.userPlan.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins="http://localhost:4200")
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
    public ResponseEntity<List<Plan>> getPlanBreakdown(@RequestParam String id) {
        System.out.println("GET user plans");
        // find all userplans for id
        List<UserPlan> userplans = userPlanService.findAllByUserId(Integer.parseInt(id));
        System.out.println(userplans);
        // find all plans within userplan set
        Set<Integer> uniquePlanIds = new HashSet<Integer>();
        for (UserPlan userplan : userplans) {
            uniquePlanIds.add(userplan.getPlanId());
        }

        List<Plan> planInfos = planService.findPlansById(uniquePlanIds);

        return new ResponseEntity<List<Plan>>(planInfos, HttpStatus.OK);
    }

    @GetMapping("/plans")
    // Users should be able to see a breakdown of their monthly bill based on their plans
    public ResponseEntity<List<Plan>> getPlans() {
        System.out.println("GET plans");
        return new ResponseEntity<List<Plan>>(planService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<String> verifyUserExists(@RequestBody User requestBody) {
        System.out.println(requestBody);

        String userName = requestBody.getUsername();
        String passWord = requestBody.getPassword();
        List<User> existingUsername = userService.findByUsername(userName);
        if (existingUsername.size() < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This user doesn't exist.");
        }
        List<User> existingUser = userService.findByUsernameAndPassword(userName, passWord);
        if (existingUser.size() == 1) {
            return ResponseEntity.status(HttpStatus.OK).body(userName);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incorrect password for username.");

    }

}
