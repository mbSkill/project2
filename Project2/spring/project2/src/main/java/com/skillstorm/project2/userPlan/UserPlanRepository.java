package com.skillstorm.project2.userPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPlanRepository extends JpaRepository<UserPlan, Integer> {
    List<UserPlan> findAllByUserId(Integer userid);
    List<UserPlan> findAllByUserIdAndPlanId(int userId, int planId);
    List<UserPlan> findDistinctByUserId(int userId);

    Integer countByUserIdAndPlanId(int userId, int planId);

    @Query("SELECT COUNT(*) FROM UserPlan uPlan WHERE uPlan.userId =?1 and uPlan.planId =?2")
    Integer countByUserIdAndPlanId(Integer userId, Integer planId);


}
