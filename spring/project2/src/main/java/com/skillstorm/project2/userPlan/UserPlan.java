package com.skillstorm.project2.userPlan;

import com.skillstorm.project2.device.Device;
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
    @Column
    int user_id;
    @Column
    int plan_id;
    @Column
    int device_id;

    @OneToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    Device device;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    User user;

    @Override
    public String toString() {
        return "UserPlan{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", plan_id=" + plan_id +
                ", device_id=" + device_id +
                ", device=" + device +
                ", user=" + user +
                '}';
    }
}
