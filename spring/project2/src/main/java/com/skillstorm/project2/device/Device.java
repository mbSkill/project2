package com.skillstorm.project2.device;

import com.skillstorm.project2.user.User;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

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
        return "Device{" + "id=" + id + ", number='" + number + '\'' + ", name='" + name + '\'' + ", user=" + user + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
