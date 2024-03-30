package com.namndt.classservice.response;

import lombok.Data;

@Data
public class AddressResponse {

    private int addressId;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private int zipCode;
}
