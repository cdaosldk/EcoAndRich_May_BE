package com.ecoAndRich.ecoandrich_may_be.domain.department.entity;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.Employee;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.entity.JobHistory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

  @Id
  private long id;

  @Column(name = "department_name")
  private String depName;

  @Column(name = "manager_id")
  private long managerId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id")
  private final Location location = new Location();

  @OneToMany(mappedBy = "department")
  private final List<Employee> employees = new ArrayList<>();

  @OneToMany(mappedBy = "department")
  private final List<JobHistory> jobHistories = new ArrayList<>();
}
