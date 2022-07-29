package com.skillstorm.project2.userPlan;


import com.skillstorm.project2.bean.CombinedUserPlan;
import com.skillstorm.project2.bean.PlanAndDeviceNumber;
import com.skillstorm.project2.device.DeviceRepository;
import com.skillstorm.project2.plan.PlanService;
import com.skillstorm.project2.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
            userPlanRepo.deleteById(id);
        }catch (Exception e)
            {e.printStackTrace();}
    }

    public List<UserPlan> findAllByUserId(Integer userId) { return userPlanRepo.findAllByUserId(userId); }

    public List<PlanAndDeviceNumber> getPlanandDevices(List<UserPlan> userPlanList){
        List<PlanAndDeviceNumber> planAndDeviceNumbers = new ArrayList<>();


        userPlanList.stream().forEach(userPlan -> {
            planAndDeviceNumbers.add(
                    new PlanAndDeviceNumber(
                            userPlan.id,
                            userPlan.device.getNumber(),
                            userPlan.plan.getName(),
                            userPlan.plan.getPrice(),
                            userPlan.plan.getDeviceLimit()
                    ));
        });
        return planAndDeviceNumbers;
    }


    private boolean isEligibleToAddPlan(UserPlan userPlan){
        int availableAdditions = planService.findOneById(userPlan.getPlanId()).getDeviceLimit();
        availableAdditions -= userPlanRepo.countByUserIdAndPlanId(userPlan.getUserId(), userPlan.getPlanId());
        return availableAdditions > 0;
    }

    public HashMap<Integer, CombinedUserPlan> getAllCombinedUserPlan(int userid){
        List<UserPlan> plans = userPlanRepo.findDistinctByUserId(userid);
        HashMap<Integer, CombinedUserPlan>  combinedUserPlans= new HashMap<>();
        plans.stream().forEach(userPlan -> {
            combinedUserPlans.put(userPlan.getPlanId(), CombinedUserPlan.builder()
                    .username(userPlan.user.getUsername())
                    .plan(userPlan.getPlan())
                    .currentPlanCount(userPlanRepo.countByUserIdAndPlanId(userPlan.userId,userPlan.planId))
                    .build());
        });
        return  combinedUserPlans;
    }

    public CombinedUserPlan getCombinedUserPlan(int userId, int planId){
        List<UserPlan> plans = userPlanRepo.findAllByUserIdAndPlanId(userId, planId);
        CombinedUserPlan combinedUserPlan = new CombinedUserPlan();
        if(plans.isEmpty()) return new CombinedUserPlan();
        combinedUserPlan.setPlan(plans.get(0).plan);
        combinedUserPlan.setUsername(plans.get(0).user.getUsername());
        combinedUserPlan.setCurrentPlanCount( plans.size() );
        return combinedUserPlan;
    }
}
