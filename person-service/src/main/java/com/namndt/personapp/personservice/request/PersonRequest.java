package com.namndt.personapp.personservice.request;

import com.namndt.personapp.personservice.response.AddressResponse;
import com.namndt.personapp.personservice.response.RoleResponse;
import com.namndt.personapp.personservice.response.SchoolClassResponse;
import lombok.Data;

@Data
public class PersonRequest {

    private int personId;

    private String name;

    private String email;

    private String mobileNum;

    private String pwd;

    private AddressResponse addressResponse;

    private RoleResponse roleResponse;

    private SchoolClassResponse schoolClassResponse;
}
