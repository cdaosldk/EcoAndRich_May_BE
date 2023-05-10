package com.ecoAndRich.ecoandrich_may_be.domain.employee.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Jobs {

  @Id
  @Column(name = "job_id")
  private String id;

  @Column(name = "job_title")
  private String jobTitle;

  @Column(name = "min_salary")
  private double minSalary;

  @Column(name = "max_salary")
  private double maxSalary;

  @OneToMany(mappedBy = "jobs")
  private final List<Employee> employees = new ArrayList<>();

  @OneToMany(mappedBy = "jobs")
  private final List<JobHistory> jobHistories = new ArrayList<>();
}
