package com.ecoAndRich.ecoandrich_may_be.domain.employee.entity;

import com.ecoAndRich.ecoandrich_may_be.domain.department.entity.Department;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "job_history")
public class JobHistory {

  @EmbeddedId
  private EmployeeIdAndStartDate employeeIdAndStartDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job_id")
  private final Jobs jobs = new Jobs();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private final Department department = new Department();
}
