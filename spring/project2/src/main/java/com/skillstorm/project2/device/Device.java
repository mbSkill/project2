package com.skillstorm.project2.device;

import com.skillstorm.project2.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "device")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String number;
    String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

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
