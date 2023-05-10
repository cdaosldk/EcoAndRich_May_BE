package com.ecoAndRich.ecoandrich_may_be.domain.employee.service;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.EmployeeResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.JobHistoryResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.Employee;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.EmployeeIdAndStartDate;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.JobHistory;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.repository.EmployeeRepository;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.repository.JobHistoryRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

  private final EmployeeRepository employeeRepository;

  private final JobHistoryRepository jobHistoryRepository;

  @Override
  public EmployeeResponseDto getEmployeeInformation(long employeeId) {
    return null;
  }

  @Override
  public JobHistoryResponseDto getJobHistoryInformation(EmployeeIdAndStartDate employeeIdAndStartDate) {
    return null;
  }

  @Override
  public EmployeeIdAndStartDate findEmbeddedId(long employeeId, LocalDate startDate) {
    return null;
  }

  private Employee findEmployee(long employeeId) {
    return null;
  }

  private JobHistory findJobHistory(EmployeeIdAndStartDate employeeIdAndStartDate) {
    return null;
  }
}
