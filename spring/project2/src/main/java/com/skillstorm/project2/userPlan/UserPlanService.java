package com.skillstorm.project2.userPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPlanService {
    @Autowired
    UserPlanRepository repo;

    public List<UserPlan> findAll(){
        return repo.findAll();
    }

    public List<UserPlan> findAllByUserId(Integer user_id) { return repo.findAllByUserId(user_id); }
}
