package com.namndt.classservice.repository;

import com.namndt.classservice.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {

    public SchoolClass findSchoolClassByClassId(int classId);
}
