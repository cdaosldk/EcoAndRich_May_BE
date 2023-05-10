package com.ecoAndRich.ecoandrich_may_be.domain.employee.repository;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findAllByDepartmentId(long depId);
}
