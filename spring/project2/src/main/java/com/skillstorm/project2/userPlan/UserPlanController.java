package com.skillstorm.project2.userPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userplan")
public class UserPlanController {
    @Autowired
    UserPlanService userPlanService;

    //Get all UserPlans
    @GetMapping
    public ResponseEntity<List<UserPlan>> getUserPlans(){
        List<UserPlan> list = userPlanService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //Create new UserPlan
    @PostMapping
    public ResponseEntity<String> saveUserPlan(@RequestBody UserPlan userPlan){
        System.out.println(userPlan);
        try{
            UserPlan uP = userPlanService.addUserPlan(userPlan);
            return ResponseEntity.ok(uP.toString());
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //Delete single UserPlan
    @DeleteMapping
    public ResponseEntity<String> deleteUserPlan(@RequestParam int id ){
        userPlanService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    //Update single userPlan
    @PutMapping
    public ResponseEntity<String> updateUserPlan(@RequestBody UserPlan userPlan){
        userPlanService.updateUserPlan(userPlan);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
