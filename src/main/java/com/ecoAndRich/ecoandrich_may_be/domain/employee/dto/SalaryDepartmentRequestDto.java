package com.ecoAndRich.ecoandrich_may_be.domain.employee.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SalaryDepartmentRequestDto {

  private long depId;

  private double raiseRate;

  public SalaryDepartmentRequestDto(long depId, double raiseRate) {
    this.depId = depId;
    this.raiseRate = raiseRate;
  }
}
