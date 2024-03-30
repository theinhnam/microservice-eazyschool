package com.namndt.holidayservice.repository;

import com.namndt.holidayservice.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, String> {
}
