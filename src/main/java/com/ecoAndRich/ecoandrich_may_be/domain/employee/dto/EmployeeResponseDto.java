package com.ecoAndRich.ecoandrich_may_be.domain.employee.dto;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.Employee;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmployeeResponseDto {

  private long employeeId;

  private String firstName;

  private String lastName;

  private String email;

  private long phoneNumber;

  private LocalDate hireDate;

  private String jobId;

  private double salary;

  private double commissionPct;

  private long managerId;

  private long depId;

  public EmployeeResponseDto(Employee employee) {
    this.employeeId = employee.getId();
    this.firstName = employee.getFirstName();
    this.lastName = employee.getLastName();
    this.email = employee.getEmail();
    this.phoneNumber = employee.getPhoneNumber();
    this.hireDate = employee.getHireDate();
    this.jobId = employee.getJobs().getId();
    this.salary = employee.getSalary();
    this.commissionPct = employee.getCommissionPct();
    this.managerId = employee.getManagerId();
    this.depId = employee.getDepartment().getId();
  }
}
