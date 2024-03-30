package com.namndt.personapp.personservice.service;

import com.namndt.personapp.personservice.dao.PersonRepo;
import com.namndt.personapp.personservice.entity.Person;
import com.namndt.personapp.personservice.feignclient.AddressClient;
import com.namndt.personapp.personservice.feignclient.RoleClient;
import com.namndt.personapp.personservice.request.AddressRequest;
import com.namndt.personapp.personservice.request.PersonRequest;
import com.namndt.personapp.personservice.response.AddressResponse;
import com.namndt.personapp.personservice.response.PersonResponse;
import com.namndt.personapp.personservice.response.RoleResponse;
import com.namndt.personapp.personservice.response.SchoolClassResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AddressClient addressClient;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleClient roleClient;

    public List<PersonResponse> getAllPerson() {
        List<Person> personList = personRepo.findAll();

        List<PersonResponse> personResponseList = Arrays.asList(modelMapper.map(personList, PersonResponse[].class));

        ResponseEntity<List<AddressResponse>> addressResponseEntity = addressClient.getAllAdress();
        List<AddressResponse> addressResponseList = addressResponseEntity.getBody();

        personList.forEach(person -> {
            addressResponseList.forEach(address -> {
                if (person.getAddressId() == address.getAddressId()) {
                    personResponseList.forEach(personRes -> {
                        if(personRes.getPersonId() == person.getPersonId()){
                            personRes.setAddressResponse(address);
                        }
                    });
                }
            });
        });

        return personResponseList;
    }


    public PersonResponse findPersonByAddressId(int id) {
        Person person = personRepo.findById(id).get();


        PersonResponse personResponse = modelMapper.map(person, PersonResponse.class);

        ResponseEntity<AddressResponse> addressResponseEntity = addressClient.getAddressById(person.getAddressId());
        AddressResponse addressResponse = addressResponseEntity.getBody();

        personResponse.setAddressResponse(addressResponse);

        return personResponse;
    }

    public void registerPerson(PersonRequest personRequest){
        Person person = modelMapper.map(personRequest, Person.class);
        person.setPwd(bCryptPasswordEncoder.encode(person.getPwd()));
        RoleResponse roleResponse = roleClient.getRoleByName("Student").getBody();
        person.setRoleId(roleResponse.getRoleId());
        Person personSaved = personRepo.save(person);
        log.info("User create successfully!");
    }

    public void updateProfile(PersonRequest personRequest){
        Optional<Person> person = personRepo.findById(personRequest.getPersonId());
        person.get().setPwd(personRequest.getPwd());
        person.get().setEmail(personRequest.getEmail());
        person.get().setName(personRequest.getName());
        person.get().setMobileNum(personRequest.getMobileNum());

        AddressRequest addressRequest = modelMapper.map(personRequest.getAddressResponse(), AddressRequest.class);

        if (person.get().getAddressId() == 0) {
            ResponseEntity<AddressResponse> addressResponseEntity = addressClient.saveAddress(addressRequest);
            AddressResponse addressResponse = addressResponseEntity.getBody();
            person.get().setAddressId(addressResponse.getAddressId());
            personRepo.save(person.get());
        }else {
            addressRequest.setAddressId(person.get().getAddressId());
            addressClient.updateAddress(addressRequest);
            personRepo.save(person.get());
        }

    }

    public PersonResponse getPersonByEmail(String email){
        Person person = personRepo.getPersonByEmail(email);
        PersonResponse personResponse = modelMapper.map(person, PersonResponse.class);
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddressId(person.getAddressId());
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setRoleId(person.getRoleId());
        SchoolClassResponse schoolClassResponse = new SchoolClassResponse();
        schoolClassResponse.setClassId(person.getClassId());
        personResponse.setAddressResponse(addressResponse);
        personResponse.setRoleResponse(roleResponse);
        personResponse.setSchoolClassResponse(schoolClassResponse);
        return personResponse;
    }


    public void addStudentToClass(PersonRequest personRequest){
        Person person = modelMapper.map(personRequest, Person.class);
        person.setClassId(personRequest.getSchoolClassResponse().getClassId());
        person.setAddressId(personRequest.getAddressResponse().getAddressId());
        person.setRoleId(personRequest.getRoleResponse().getRoleId());
        personRepo.save(person);
    }
}
