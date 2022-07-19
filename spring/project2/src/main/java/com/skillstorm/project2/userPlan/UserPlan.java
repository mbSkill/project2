package com.skillstorm.project2.userPlan;

import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_plan")
public class UserPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

//    @OneToOne
//    @JoinColumn(name = "plan_id")
//    Plan plan;

    int plan_id;

    @OneToOne
    @JoinColumn(name = "device_id")
    Device device;

    @Override
    public String toString() {
        return "UserPlan{" +
                "id=" + id +
                ",\nuser=" + user +
                ", \n plan_id=" + plan_id +
                ", \ndevice=" + device +
                "}\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
