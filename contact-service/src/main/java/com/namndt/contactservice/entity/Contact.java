package com.namndt.contactservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contact_msg")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contactId;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_num")
    private String mobileNum;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @Column(name = "status")
    private String status;
}
