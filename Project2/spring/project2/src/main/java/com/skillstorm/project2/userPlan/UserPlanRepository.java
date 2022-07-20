package com.skillstorm.project2.userPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPlanRepository extends JpaRepository<UserPlan, Integer> {
    List<UserPlan> findAllByUserId(Integer userid);


}
