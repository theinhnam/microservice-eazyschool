package com.namndt.personapp.personservice.controller;

import com.namndt.personapp.personservice.request.PersonRequest;
import com.namndt.personapp.personservice.response.PersonResponse;
import com.namndt.personapp.personservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<List<PersonResponse>> getAllPerson(){
        List<PersonResponse> personResponses = personService.getAllPerson();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personResponses);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable("personId") int id){
        PersonResponse personResponse = personService.findPersonByAddressId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerPerson(@RequestBody PersonRequest personRequest){
        personService.registerPerson(personRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Person save successfully");
    }

    @PatchMapping("/person/{personId}")
    public ResponseEntity<String> updateProfile(@RequestBody PersonRequest personRequest,
                                                @PathVariable("personId") int personId) {
        personRequest.setPersonId(personId);
        personService.updateProfile(personRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Update profile successfully");
    }

    @GetMapping("/search-person")
    public ResponseEntity<PersonResponse> getPersonByEmail(@RequestParam String email){
        PersonResponse personResponse = personService.getPersonByEmail(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personResponse);
    }

    @PutMapping("/add-student-to-class")
    public ResponseEntity<String> addStudentToClass(@RequestBody PersonRequest personRequest){
        personService.addStudentToClass(personRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Add student to class successfully");
    }

}
