package com.ecoAndRich.ecoandrich_may_be.domain.department.controller;

import com.ecoAndRich.ecoandrich_may_be.domain.department.dto.DepartmentResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.department.service.DepartmentService;
import com.ecoAndRich.ecoandrich_may_be.util.SetHttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

  private final DepartmentService departmentService;

  private final SetHttpHeaders setHttpHeaders;

  @GetMapping("/{depId}")
  public ResponseEntity<DepartmentResponseDto> getDepartmentAndLocation(@PathVariable long depId) {
    return ResponseEntity.ok().headers(setHttpHeaders.setHeaderTypeJson()).body(
        departmentService.getDepartmentAndLocation(depId));
  }
}
