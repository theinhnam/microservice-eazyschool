package com.namndt.contactservice.controller;

import com.namndt.contactservice.request.ContactRequest;
import com.namndt.contactservice.response.ContactResponse;
import com.namndt.contactservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contact")
    public ResponseEntity<List<ContactResponse>> getAllContactMessage(){
        List<ContactResponse> contactResponseList = contactService.getAllContactMsg();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contactResponseList);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<String> saveMsg(@RequestBody ContactRequest contactRequest){
        contactService.saveMsg(contactRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Save messsage successfully");
    }

    @PutMapping("/updateMsg/{contactId}")
    public ResponseEntity<String> updateMsg(@PathVariable("contactId") int id){
        contactService.closeMsg(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Update message successfully");
    }

}
