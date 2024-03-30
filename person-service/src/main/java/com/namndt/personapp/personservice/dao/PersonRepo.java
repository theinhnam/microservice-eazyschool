package com.namndt.personapp.personservice.dao;

import com.namndt.personapp.personservice.entity.Person;
import com.namndt.personapp.personservice.request.PersonRequest;
import com.namndt.personapp.personservice.response.PersonResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    public Person getPersonByEmail(String email);
}
