package com.ecoAndRich.ecoandrich_may_be.domain.department.dto;

import com.ecoAndRich.ecoandrich_may_be.domain.department.entity.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepartmentResponseDto {

  private long depId;

  private String depName;

  public DepartmentResponseDto(Department department) {
    this.depId = department.getId();
    this.depName = department.getDepName();
  }
}
