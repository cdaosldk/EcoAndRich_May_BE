package com.ecoAndRich.ecoandrich_may_be.domain.employee.service;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.EmployeeResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.JobHistoryResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.EmployeeIdAndStartDate;
import java.time.LocalDate;

public interface EmployeeService {

  public EmployeeResponseDto getEmployeeInformation(long employeeId);

  public JobHistoryResponseDto getJobHistoryInformation(EmployeeIdAndStartDate employeeIdAndStartDate);

  public EmployeeIdAndStartDate createEmbeddedId(long employeeId, LocalDate startDate);

}
