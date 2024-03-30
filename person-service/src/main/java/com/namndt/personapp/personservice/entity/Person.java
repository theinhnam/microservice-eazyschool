package com.namndt.personapp.personservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNum;

    @Column(name = "address_id")
    private int addressId;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "class_id")
    private int classId;

    @Column(name = "pwd")
    private String pwd;
}
