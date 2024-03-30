package com.namndt.courseservice.service;

import com.namndt.courseservice.dao.CourseRepository;
import com.namndt.courseservice.entity.Course;
import com.namndt.courseservice.response.CourseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModelMapper modelMapper;

    public CourseResponse getCourseById(int id){
        Course course = courseRepository.findById(id).get();
        CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
        return courseResponse;
    }
}
