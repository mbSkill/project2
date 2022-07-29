package com.skillstorm.project2.plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping()
public class PlanController {
    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/plan")
    public List<Plan> getAllPlan(){
        return planRepository.findAll();
    }

}