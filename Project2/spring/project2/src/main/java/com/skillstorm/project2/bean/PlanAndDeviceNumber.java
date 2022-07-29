package com.skillstorm.project2.bean;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class PlanAndDeviceNumber {
    int userPlanId;
    String phoneNumber;
    String PlanName;
    float price;
    int deviceLimit;
}
