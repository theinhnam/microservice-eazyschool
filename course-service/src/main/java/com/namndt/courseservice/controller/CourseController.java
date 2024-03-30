package com.namndt.courseservice.controller;

import com.namndt.courseservice.response.CourseResponse;
import com.namndt.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/course/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable("id") int id){
        CourseResponse courseResponse = courseService.getCourseById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseResponse);
    }
}
