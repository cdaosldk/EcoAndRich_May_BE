package com.ecoAndRich.ecoandrich_may_be.domain.employee.repository;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.EmployeeIdAndStartDate;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, EmployeeIdAndStartDate> {

}
