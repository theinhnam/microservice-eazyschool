package com.namndt.classservice.controller;

import com.namndt.classservice.request.SchoolClassRequest;
import com.namndt.classservice.response.SchoolClassResponse;
import com.namndt.classservice.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolClassController {

    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping("/classes")
    public ResponseEntity<List<SchoolClassResponse>> getAll(){
        List<SchoolClassResponse> schoolClassResponseList = schoolClassService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(schoolClassResponseList);
    }

    @PostMapping("/saveClass")
    public ResponseEntity<String> saveClass(@RequestBody SchoolClassRequest schoolClassRequest){
        schoolClassService.saveSchoolClass(schoolClassRequest);
        return ResponseEntity.status(HttpStatus.OK).body("save class successfully");
    }

    @PostMapping("/add-student-to-class/{classId}")
    public ResponseEntity<String> addStudentToClass(@PathVariable("classId") int classId, @RequestParam String email){
        schoolClassService.addStudentToClass(classId, email);
        return ResponseEntity.status(HttpStatus.OK).body("Add student to class successfully");
    }
}
