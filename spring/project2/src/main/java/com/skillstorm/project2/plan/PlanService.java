package com.skillstorm.project2.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    @Autowired
    PlanRepository repo;

    public List<Plan> findPlanById(List<Integer> ids){
        return repo.findAllById(ids);
    }

    public List<Plan> findAll() { return repo.findAll(); }
}
