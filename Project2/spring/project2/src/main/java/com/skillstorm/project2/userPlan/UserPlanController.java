package com.skillstorm.project2.userPlan;

import com.skillstorm.project2.bean.PlanAndDeviceNumber;
import com.skillstorm.project2.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userplan")
public class UserPlanController {
    @Autowired
    UserPlanService userPlanService;
    @Autowired
    UserService userService;


    //Get UserPlans
    @GetMapping("/{id}")
    public ResponseEntity<List<PlanAndDeviceNumber>> getUserPlansByID(@PathVariable int id){
        List<UserPlan> list = userPlanService.findAllByUserId(id);
        List<PlanAndDeviceNumber> planAndDeviceNumbers = userPlanService.getPlanandDevices(list);
        return new ResponseEntity<>(planAndDeviceNumbers, HttpStatus.OK);
    }
    //Get all UserPlans
    @GetMapping("/askdjflska")
    public ResponseEntity<List<UserPlan>> getUserPlans(){
        List<UserPlan> list = userPlanService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //Create new UserPlan
    @PostMapping("/")
    public ResponseEntity<String> saveUserPlan(
            @CurrentSecurityContext(expression="authentication?.name") String username,
            @RequestBody UserPlan userPlan){
        System.out.println(username + ": " + userPlan );
        try{
            if(userService.findByUsername(username).stream().findFirst().get().getId() != userPlan.userId){
                return new ResponseEntity<>("You do not have the permissions to do this.", HttpStatus.UNAUTHORIZED);
            }

            UserPlan uP = userPlanService.addUserPlan(userPlan);
            return ResponseEntity.ok(uP.toString());
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //Delete single UserPlan
    @DeleteMapping("/")
    public ResponseEntity<String> deleteUserPlan(@RequestParam int id ){
        userPlanService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    //Update single userPlan
    @PutMapping("/")
    public ResponseEntity<String> updateUserPlan(@RequestBody UserPlan userPlan){
        userPlanService.updateUserPlan(userPlan);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
