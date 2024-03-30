package com.namndt.personapp.personservice.feignclient;

import com.namndt.personapp.personservice.request.AddressRequest;
import com.namndt.personapp.personservice.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "address-service",  path = "/address-app/api")
public interface AddressClient {

    @GetMapping("/address")
    public ResponseEntity<List<AddressResponse>> getAllAdress();

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") int id);

    @PostMapping("/saveAddress")
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressRequest addressRequest);

    @PutMapping("/updateAddress")
    public ResponseEntity<String> updateAddress(@RequestBody AddressRequest addressRequest);
}
