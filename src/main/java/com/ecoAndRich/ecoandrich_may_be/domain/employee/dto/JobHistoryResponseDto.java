package com.ecoAndRich.ecoandrich_may_be.domain.employee.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JobHistoryResponseDto {

  private long employeeId;

  private LocalDate startDate;


  public JobHistoryResponseDto(long employeeId) {
    this.employeeId = employeeId;
  }
}
