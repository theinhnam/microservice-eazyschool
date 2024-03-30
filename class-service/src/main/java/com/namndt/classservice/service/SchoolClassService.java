package com.namndt.classservice.service;

import com.namndt.classservice.entity.SchoolClass;
import com.namndt.classservice.feignclient.PersonClient;
import com.namndt.classservice.repository.SchoolClassRepository;
import com.namndt.classservice.request.PersonRequest;
import com.namndt.classservice.request.SchoolClassRequest;
import com.namndt.classservice.response.PersonResponse;
import com.namndt.classservice.response.SchoolClassResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SchoolClassService {

    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonClient personClient;

    public List<SchoolClassResponse> getAll(){
        List<SchoolClass> schoolClassList = schoolClassRepository.findAll();
        List<SchoolClassResponse> schoolClassResponseList = Arrays.asList(modelMapper.map(schoolClassList, SchoolClassResponse[].class));
        return schoolClassResponseList;
    }

    public void saveSchoolClass(SchoolClassRequest schoolClassRequest){
        SchoolClass schoolClass = modelMapper.map(schoolClassRequest, SchoolClass.class);
        schoolClassRepository.save(schoolClass);
    }

    public void addStudentToClass(int classId, String email){
        PersonResponse personResponse = personClient.getPersonByEmail(email).getBody();
        SchoolClassResponse schoolClassResponse = new SchoolClassResponse();
        schoolClassResponse.setClassId(classId);
        personResponse.setSchoolClassResponse(schoolClassResponse);
        PersonRequest personRequest = modelMapper.map(personResponse, PersonRequest.class);
        personClient.addStudentToClass(personRequest);
    }
}
