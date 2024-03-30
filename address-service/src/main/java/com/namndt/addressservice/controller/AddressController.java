package com.namndt.addressservice.controller;

import com.namndt.addressservice.request.AddressRequest;
import com.namndt.addressservice.response.AddressResponse;
import com.namndt.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<AddressResponse>> getAllAdress(){
        List<AddressResponse> addressResponses = addressService.getAllAddress();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressResponses);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressDetail(@PathVariable("id") int id){

        AddressResponse addressResponse = addressService.getAddressDetail(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressResponse);
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = addressService.saveAddress(addressRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressResponse);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<String> updateAddress(@RequestBody AddressRequest addressRequest){
        addressService.updateAddress(addressRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Address update successfully");
    }
}
