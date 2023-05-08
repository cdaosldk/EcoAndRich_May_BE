package com.ecoAndRich.ecoandrich_may_be.domain.department.service;

import com.ecoAndRich.ecoandrich_may_be.domain.department.dto.DepartmentResponseDto;

public interface DepartmentService {

  public DepartmentResponseDto getDepartmentAndLocation(long depId);

}
