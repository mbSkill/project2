package com.skillstorm.project2.plan;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "plan")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    float price;
    int deviceLimit;
}
