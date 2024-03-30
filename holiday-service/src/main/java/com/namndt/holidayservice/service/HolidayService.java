package com.namndt.holidayservice.service;

import com.namndt.holidayservice.entity.Holiday;
import com.namndt.holidayservice.repository.HolidayRepository;
import com.namndt.holidayservice.response.HolidayResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HolidayService {

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<HolidayResponse> getAllHoliday(){
        List<Holiday> holidays = holidayRepository.findAll();
        List<HolidayResponse> holidayResponses = Arrays.asList(modelMapper.map(holidays, HolidayResponse[].class));
        return holidayResponses;
    }
}
