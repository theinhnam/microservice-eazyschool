package com.namndt.contactservice.response;

import lombok.Data;

@Data
public class ContactResponse {
    private int contactId;

    private String name;

    private String mobileNum;

    private String email;

    private String subject;

    private String message;

    private String status;
}
