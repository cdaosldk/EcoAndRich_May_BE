package com.ecoAndRich.ecoandrich_may_be.domain.employee.service;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.EmployeeResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.EmployeeUpdateDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.JobHistoryResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.SalaryDepartmentRequestDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.EmployeeIdAndStartDate;
import java.time.LocalDate;

public interface EmployeeService {

  EmployeeResponseDto getEmployeeInformation(long employeeId);

  JobHistoryResponseDto getJobHistoryInformation(EmployeeIdAndStartDate employeeIdAndStartDate);

  EmployeeIdAndStartDate createEmbeddedId(long employeeId, LocalDate startDate);

  void raiseSalaryOfDepartment(SalaryDepartmentRequestDto salaryDepartmentRequestDto);

  void updateEmployeeImformation(long employeeId, EmployeeUpdateDto employeeUpdateDto);

}
