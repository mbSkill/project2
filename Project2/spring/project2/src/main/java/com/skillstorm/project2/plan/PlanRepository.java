package com.skillstorm.project2.plan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
    public Plan findOneById(int id);
}
