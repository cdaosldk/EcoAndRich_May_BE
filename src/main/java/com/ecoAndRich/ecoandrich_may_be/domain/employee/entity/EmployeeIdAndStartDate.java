package com.ecoAndRich.ecoandrich_may_be.domain.employee.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeIdAndStartDate implements Serializable{

  private long employeeId;

  private LocalDate startDate;

}
