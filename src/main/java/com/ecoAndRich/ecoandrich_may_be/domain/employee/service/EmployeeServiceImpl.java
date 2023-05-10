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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

  private final EmployeeRepository employeeRepository;

  private final JobHistoryRepository jobHistoryRepository;

  @Override
  @Transactional(readOnly = true)
  public EmployeeResponseDto getEmployeeInformation(long employeeId) {
    Employee employee = findEmployee(employeeId);
    return new EmployeeResponseDto(employee);
  }

  @Override
  @Transactional(readOnly = true)
  public JobHistoryResponseDto getJobHistoryInformation(EmployeeIdAndStartDate employeeIdAndStartDate) {
    JobHistory jobHistory = findJobHistory(employeeIdAndStartDate);
    return new JobHistoryResponseDto(jobHistory);
  }

  @Override
  @Transactional
  public EmployeeIdAndStartDate createEmbeddedId(long employeeId, LocalDate startDate) {
    return new EmployeeIdAndStartDate(employeeId, startDate);
  }

  private Employee findEmployee(long employeeId) {
    return employeeRepository.findById(employeeId).orElseThrow(
        () -> new IllegalArgumentException("존재하지 않는 직원입니다.")
    );
  }

  private JobHistory findJobHistory(EmployeeIdAndStartDate employeeIdAndStartDate) {
    return jobHistoryRepository.findById(employeeIdAndStartDate).orElseThrow(
        () -> new IllegalArgumentException("존재하지 않는 이력입니다.")
    );
  }
}
