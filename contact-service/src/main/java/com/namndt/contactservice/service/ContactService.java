package com.namndt.contactservice.service;

import com.namndt.contactservice.ContactConstrants;
import com.namndt.contactservice.entity.Contact;
import com.namndt.contactservice.repository.ContactRepository;
import com.namndt.contactservice.request.ContactRequest;
import com.namndt.contactservice.response.ContactResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<ContactResponse> getAllContactMsg(){
        List<Contact> contactList = contactRepository.findContactByStatus(ContactConstrants.OPEN);
        List<ContactResponse> contactResponseList = Arrays.asList(modelMapper.map(contactList, ContactResponse[].class));
        return contactResponseList;
    }

    public void saveMsg(ContactRequest contactRequest){
        Contact contact = modelMapper.map(contactRequest, Contact.class);
        contact.setStatus("Open");
        contactRepository.save(contact);
    }

    public void closeMsg(int contactId){
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.get().setStatus(ContactConstrants.CLOSE);
        contactRepository.save(contact.get());
    }

}
