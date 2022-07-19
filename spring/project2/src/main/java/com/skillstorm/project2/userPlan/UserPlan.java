package com.skillstorm.project2.userPlan;

import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.plan.Plan;
import com.skillstorm.project2.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_plan")
public class UserPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    /*
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;*/
    int userId;

    /*
    @OneToOne
    @JoinColumn(name = "plan_id")
    Plan plan;
*/

    int planId;

    /*
    @OneToOne
    @JoinColumn(name = "device_id")
    Device device;*/
    int deviceId;

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
