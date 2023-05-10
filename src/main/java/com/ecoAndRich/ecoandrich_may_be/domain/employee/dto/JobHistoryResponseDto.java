package com.ecoAndRich.ecoandrich_may_be.domain.employee.dto;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.EmployeeIdAndStartDate;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.JobHistory;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JobHistoryResponseDto {

  private EmployeeIdAndStartDate employeeIdAndStartDate;

  private LocalDate endDate;

  private String jobId;

  private long depId;

  public JobHistoryResponseDto(JobHistory jobHistory) {
    this.employeeIdAndStartDate = jobHistory.getEmployeeIdAndStartDate();
    this.endDate = jobHistory.getEndDate();
    this.jobId = jobHistory.getJobs().getId();
    this.depId = jobHistory.getDepartment().getId();
  }
}
