package com.dutta.k8s.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
@ToString@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy =GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String country;


}
