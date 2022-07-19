package com.skillstorm.project2.device;

import com.skillstorm.project2.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "device")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String number;
    String name;

    int user_id;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
