package com.ecoAndRich.ecoandrich_may_be.domain.employee.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmployeeUpdateDto {

  private String firstName;

  private String lastName;

  private String email;

  private long phoneNumber;

  private double salary;

  private double comissionPct;

  private long managerId;

  public EmployeeUpdateDto(String firstName, String lastName, String email, long phoneNumber,
      double salary, double comissionPct, long managerId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.salary = salary;
    this.comissionPct = comissionPct;
    this.managerId = managerId;
  }
}
