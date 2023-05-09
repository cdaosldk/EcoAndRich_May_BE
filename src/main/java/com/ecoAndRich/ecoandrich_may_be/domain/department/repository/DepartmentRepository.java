package com.ecoAndRich.ecoandrich_may_be.domain.department.repository;

import com.ecoAndRich.ecoandrich_may_be.domain.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
