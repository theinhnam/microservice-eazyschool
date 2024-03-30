package com.namndt.personapp.personservice.request;

import lombok.Data;

@Data
public class AddressRequest {
    private int addressId;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private int zipCode;
}
