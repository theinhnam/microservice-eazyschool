package com.namndt.contactservice.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ContactRequest {
    private int contactId;

    private String name;

    private String mobileNum;

    private String email;

    private String subject;

    private String message;

    private String status;
}
