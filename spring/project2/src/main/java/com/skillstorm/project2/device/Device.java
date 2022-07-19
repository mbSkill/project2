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
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    int user_id;

    public Device() {}

    public Device(String number, String name, User user) {
        this.number = number;
        this.name = name;
        this.user = user;
    }

    public Device(int id, String number, String name, User user) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.user = user;
    }

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
