package com.skillstorm.project2.userPlan;


import com.skillstorm.project2.bean.PlanAndDeviceNumber;
import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<PlanAndDeviceNumber> getPlanandDevices(List<UserPlan> userPlanList){
        List<PlanAndDeviceNumber> planAndDeviceNumbers = new ArrayList<>();
        userPlanList.stream().forEach(userPlan -> {
            planAndDeviceNumbers.add(
                    new PlanAndDeviceNumber(
                            userPlan.device.getNumber(),
                            userPlan.plan.getName(),
                            userPlan.plan.getPrice(),
                            userPlan.plan.getDeviceLimit()
                    ));
        });
        return planAndDeviceNumbers;
    }


    private boolean isEligibleToAddPlan(UserPlan userPlan){
        int availableAdditions = planService.findOneById(5).getDeviceLimit();
        availableAdditions -= userPlanRepo.countByUserIdAndPlanId(userPlan.getUserId(), 5);
        return availableAdditions > 0;
    }
}
