package com.ecoAndRich.ecoandrich_may_be.domain.department.service;

import com.ecoAndRich.ecoandrich_may_be.domain.department.dto.DepartmentResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.department.entity.Department;
import com.ecoAndRich.ecoandrich_may_be.domain.department.entity.Location;
import com.ecoAndRich.ecoandrich_may_be.domain.department.repository.DepartmentRepository;
import com.ecoAndRich.ecoandrich_may_be.domain.department.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

  private final DepartmentRepository departmentRepository;

  private final LocationRepository locationRepository;

  @Override
  public DepartmentResponseDto getDepartmentAndLocation(long depId) {
    Department department = findDepartment(depId);
    findLocation(department.getLocation().getId());
    return new DepartmentResponseDto(department);
  }

  private Department findDepartment(long depId) {
    return departmentRepository.findById(depId).orElseThrow(
        () -> new IllegalArgumentException("존재하지 않는 부서입니다.")
    );
  }

  private Location findLocation(long locationId) {
    return locationRepository.findById(locationId).orElseThrow(
        () -> new IllegalArgumentException("존재하지 않는 지역입니다.")
    );
  }
}
