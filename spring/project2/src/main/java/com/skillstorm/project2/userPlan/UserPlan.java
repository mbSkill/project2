package com.skillstorm.project2.userPlan;

import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.plan.Plan;
import com.skillstorm.project2.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_plan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    int id;

    @Column(name = "user_id")
    int userId;

    @Column(name = "plan_id")
    int planId;

    @Column(name = "device_id")
    int deviceId;

    @OneToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    Device device;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    User user;

    @OneToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    Plan plan;

}
