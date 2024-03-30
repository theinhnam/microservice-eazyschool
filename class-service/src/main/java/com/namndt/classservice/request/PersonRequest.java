package com.namndt.classservice.request;

import com.namndt.classservice.response.AddressResponse;
import com.namndt.classservice.response.RoleResponse;
import com.namndt.classservice.response.SchoolClassResponse;
import lombok.Data;

@Data
public class PersonRequest {
    private int personId;

    private String name;

    private String email;

    private String mobileNum;

    private String pwd;

    private int classId;

    private AddressResponse addressResponse;

    private RoleResponse roleResponse;

    private SchoolClassResponse schoolClassResponse;
}
