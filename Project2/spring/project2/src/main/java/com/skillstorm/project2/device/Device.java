package com.skillstorm.project2.device;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "device")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    int userId;

}
