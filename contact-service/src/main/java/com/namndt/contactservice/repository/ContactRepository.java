package com.namndt.contactservice.repository;

import com.namndt.contactservice.entity.Contact;
import com.namndt.contactservice.response.ContactResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    public List<Contact> findContactByStatus(String status);
}
