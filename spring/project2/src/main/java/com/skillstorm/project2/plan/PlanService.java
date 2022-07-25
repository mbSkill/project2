package com.skillstorm.project2.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PlanService {
    @Autowired
    PlanRepository repo;

    public List<Plan> findPlansById(Set<Integer> ids){
        return repo.findAllById(ids);
    }
    public Plan findOneById(int id){ return repo.findOneById(id);}

    public List<Plan> findAll() { return repo.findAll(); }

//    public Integer getDeviceLimit(int id){
//        return repo.findById(id).ifPresent(re);
//    }
}
