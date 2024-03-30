package com.namndt.addressservice.service;

import com.namndt.addressservice.request.AddressRequest;
import com.namndt.addressservice.dao.AddressRepo;
import com.namndt.addressservice.entity.Address;
import com.namndt.addressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    ModelMapper modelMapper;

    public List<AddressResponse> getAllAddress(){
        List<Address> addressList = addressRepo.findAll();

        List<AddressResponse> addressResponseList = Arrays.asList(modelMapper.map(addressList, AddressResponse[].class));

        return addressResponseList;
    }

    public AddressResponse getAddressDetail(int id){
        Address address = addressRepo.findById(id).get();

        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);

        return addressResponse;
    }

    public AddressResponse saveAddress(AddressRequest addressRequest){
        Address address = modelMapper.map(addressRequest, Address.class);
        Address addressSaved = addressRepo.save(address);
        AddressResponse addressResponse = modelMapper.map(addressSaved, AddressResponse.class);
        return addressResponse;
    }

    public void updateAddress(AddressRequest addressRequest){
        Address address = modelMapper.map(addressRequest, Address.class);
        addressRepo.save(address);
    }
}
