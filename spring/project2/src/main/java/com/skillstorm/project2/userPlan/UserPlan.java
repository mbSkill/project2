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

    /*
    @JoinColumn(name = "device_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    Device device;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    User user;
    */

    @Override
    public String toString() {
        return "UserPlan{" +
                "id=" + id +
                ", userId=" + userId +
                ", planId=" + planId +
                ", deviceId=" + deviceId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
