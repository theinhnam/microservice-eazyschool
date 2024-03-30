package com.namndt.holidayservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "holidays")
public class Holiday {
    @Id
    @Column(name = "day")
    private String day;

    @Column(name = "reason")
    private String reason;

    @Column(name = "type")
    private String type;
}
