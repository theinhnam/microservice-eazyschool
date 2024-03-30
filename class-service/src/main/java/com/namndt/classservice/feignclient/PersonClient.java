package com.namndt.classservice.feignclient;

import com.namndt.classservice.request.PersonRequest;
import com.namndt.classservice.response.PersonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "person-service", path = "/person-app/api")
public interface PersonClient {

    @GetMapping("/search-person")
    public ResponseEntity<PersonResponse> getPersonByEmail(@RequestParam String email);

    @PutMapping("/add-student-to-class")
    public ResponseEntity<String> addStudentToClass(@RequestBody PersonRequest personRequest);

}