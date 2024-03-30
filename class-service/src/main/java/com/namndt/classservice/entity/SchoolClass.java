package com.namndt.classservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "class")
@Data
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

    @Column(name = "name")
    private String name;

}
