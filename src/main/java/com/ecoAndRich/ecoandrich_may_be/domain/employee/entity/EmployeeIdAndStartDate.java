package com.ecoAndRich.ecoandrich_may_be.domain.employee.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class EmployeeIdAndStartDate implements Serializable{

  private long employeeId;

  private LocalDate startDate;

  public EmployeeIdAndStartDate(long employeeId, LocalDate startDate) {
    this.employeeId = employeeId;
    this.startDate = startDate;
  }
}
