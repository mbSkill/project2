package com.skillstorm.project2.userPlan;


import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserPlanService {
    @Autowired
    UserPlanRepository userPlanRepo;
    @Autowired
    DeviceRepository deviceRepo;
    @Autowired
    PlanService planService;

    public UserPlan addUserPlan(UserPlan userPlan){
        if (!isEligibleToAddPlan(userPlan)) {
        return userPlan;
        }
        return userPlanRepo.saveAndFlush(UserPlan.builder()
               .userId(userPlan.getUserId())
               .planId(userPlan.getPlanId())
               .deviceId(userPlan.getDeviceId())
               .build());
    }

    public void updateUserPlan(UserPlan userPlan){
        Optional<UserPlan> currentUserPlan = userPlanRepo.findById(userPlan.id);
        if(currentUserPlan.isPresent()) {
            userPlanRepo.save(userPlan);
        }
    }


    public List<UserPlan> findAll() {
        System.out.println(isEligibleToAddPlan(new UserPlan()));
        return userPlanRepo.findAll();
    }

    public void deleteById(int id) {
        try{
            deviceRepo.deleteById(id);
        }catch (Exception e)
            {e.printStackTrace();}
    }

    public List<UserPlan> findAllByUserId(Integer userId) { return userPlanRepo.findAllByUserId(userId); }

    private boolean isEligibleToAddPlan(UserPlan userPlan){
        int availableAdditions = planService.findOneById(4).getDeviceLimit();
        availableAdditions -= userPlanRepo.countByUserIdAndPlanId(5, 4);
        return availableAdditions > 0;
    }
}
