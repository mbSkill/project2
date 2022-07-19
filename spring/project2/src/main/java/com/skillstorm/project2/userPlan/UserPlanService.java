package com.skillstorm.project2.userPlan;


import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserPlanService {
    @Autowired
    UserPlanRepository userPlanRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    DeviceRepository deviceRepo;

    public UserPlan addUserPlan(UserPlan userPlan){
       Device device= deviceRepo.saveAndFlush(

               Device.builder()
                .name("Pixal")
                .number("555-555-0004")
                .user_id(userPlan.getUser_id())
                .build());

        return userPlanRepo.saveAndFlush(UserPlan.builder()
               .user_id(userPlan.getUser_id())
               .plan_id(userPlan.getPlan_id())
               .device_id(device.getId())
               .build()
       );
    }

    public void updateUserPlan(UserPlan userPlan){
        Optional<UserPlan> currentUserPlan = userPlanRepo.findById(userPlan.id);
        if(currentUserPlan.isPresent()) {
            userPlanRepo.save(userPlan);
        }
    }


    public List<UserPlan> findAll() {
        return userPlanRepo.findAll();
    }

    public void deleteById(int id) {
        try{
            deviceRepo.deleteById(id);
        }catch (Exception e)
            {e.printStackTrace();}
    }
}
