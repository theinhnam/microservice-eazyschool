package com.namndt.holidayservice.response;

import lombok.Data;

@Data
public class HolidayResponse {
    private String day;

    private String reason;

    private String type;
}
