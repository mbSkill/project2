package com.skillstorm.project2.userPlan;

import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.user.User;
import com.skillstorm.project2.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserPlanService {
    @Autowired
    UserPlanRepository userPlanRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    DeviceRepository deviceRepo;

    public UserPlan addUserPlan(){
       User user = userRepo.getReferenceById(8);
       System.out.println(user.getId());

       Device device= deviceRepo.saveAndFlush(Device.builder()
                .name("Pixal")
                .number("555-555-0004")
                .user(user)
                .build());

        System.out.println(device);


        return userPlanRepo.saveAndFlush(UserPlan.builder()
                .user(user)
                .plan_id(8)
                .device(device)
                .build()
        );
    }

}
