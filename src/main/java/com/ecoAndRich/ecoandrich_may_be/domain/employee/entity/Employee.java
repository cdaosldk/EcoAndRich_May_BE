package com.ecoAndRich.ecoandrich_may_be.domain.employee.entity;

import com.ecoAndRich.ecoandrich_may_be.TimeStamped;
import com.ecoAndRich.ecoandrich_may_be.domain.department.entity.Department;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.EmployeeUpdateDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends TimeStamped {

  @Id
  @Column(name = "employee_id")
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number")
  private long phoneNumber;

  @Column(name = "salary")
  private double salary;

  @Column(name = "commission_pct")
  private double commissionPct;

  @Column(name = "manager_id")
  private long managerId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job_id")
  private final Jobs jobs = new Jobs();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private final Department department = new Department();

  public void updateSalary(double raiseRate) {
    this.salary = salary * raiseRate;
  }

  public void updateEmployee(EmployeeUpdateDto employeeUpdateDto) {
    this.firstName = employeeUpdateDto.getFirstName();
    this.lastName = employeeUpdateDto.getLastName();
    this.email = employeeUpdateDto.getEmail();
    this.phoneNumber = employeeUpdateDto.getPhoneNumber();
    this.salary = employeeUpdateDto.getSalary();
    this.commissionPct = employeeUpdateDto.getComissionPct();
    this.managerId = employeeUpdateDto.getManagerId();
  }
}
