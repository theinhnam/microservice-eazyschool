package com.namndt.personapp.personservice.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonResponse {

    private int personId;

    private String name;

    private String email;

    private String mobileNum;

    private String pwd;

    private SchoolClassResponse schoolClassResponse;

    private RoleResponse roleResponse;

    private AddressResponse addressResponse;
}

