package com.skillstorm.project2.plan;

import javax.persistence.*;

@Entity
@Table(name = "plan")
/*
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `device_limit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
 */

public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    float price;

    int deviceLimit;


    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", deviceLimit=" + deviceLimit +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDeviceLimit() {
        return deviceLimit;
    }

    public void setDeviceLimit(int deviceLimit) {
        this.deviceLimit = deviceLimit;
    }
}
