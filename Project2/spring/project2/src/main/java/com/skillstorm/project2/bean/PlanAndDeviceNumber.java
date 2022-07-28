package com.skillstorm.project2.bean;

import com.skillstorm.project2.userPlan.UserPlan;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PlanAndDeviceNumber {
    String phoneNumber;
    String PlanName;
    float price;
    int deviceLimit;
}
