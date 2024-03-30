package com.namndt.holidayservice.controller;

import com.namndt.holidayservice.response.HolidayResponse;
import com.namndt.holidayservice.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HolidayController {

    @Autowired
    HolidayService holidayService;

    @GetMapping("/holidays")
    public ResponseEntity<List<HolidayResponse>> getAllHoliday(){
        List<HolidayResponse> holidayResponseList = holidayService.getAllHoliday();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(holidayResponseList);
    }

}
