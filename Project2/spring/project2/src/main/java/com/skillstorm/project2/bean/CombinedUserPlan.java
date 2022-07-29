package com.skillstorm.project2.bean;

import com.skillstorm.project2.plan.Plan;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CombinedUserPlan {
    Plan plan;
    String username;
    int currentPlanCount;

}
