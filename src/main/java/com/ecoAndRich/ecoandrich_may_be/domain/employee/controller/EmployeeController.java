package com.ecoAndRich.ecoandrich_may_be.domain.employee.controller;

import static com.ecoAndRich.ecoandrich_may_be.util.HttpResponseEntity.RESPONSE_OK;

import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.EmployeeResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.EmployeeUpdateDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.JobHistoryResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.dto.SalaryDepartmentRequestDto;
import com.ecoAndRich.ecoandrich_may_be.domain.employee.service.EmployeeService;
import com.ecoAndRich.ecoandrich_may_be.dto.StatusResponseDto;
import com.ecoAndRich.ecoandrich_may_be.util.SetHttpHeaders;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

  private final EmployeeService employeeService;

  private final SetHttpHeaders setHttpHeaders;

  @GetMapping("/{employeeId}")
  public ResponseEntity<EmployeeResponseDto> getEmployeeInformation(@PathVariable long employeeId) {
    return ResponseEntity.ok().headers(setHttpHeaders.setHeaderTypeJson()).body(
        employeeService.getEmployeeInformation(employeeId));
  }

  @GetMapping("/{employeeId}/{startDate}")
  public ResponseEntity<JobHistoryResponseDto> getJobhistoryInformation(@PathVariable long employeeId, @PathVariable
      LocalDate startDate) {
    return ResponseEntity.ok().headers(setHttpHeaders.setHeaderTypeJson()).body(
        employeeService.getJobHistoryInformation(employeeService.createEmbeddedId(employeeId, startDate)));
  }

  @PostMapping
  public ResponseEntity<StatusResponseDto> raiseSalaryOfDepartment(@RequestBody SalaryDepartmentRequestDto salaryDepartmentRequestDto) {
    employeeService.raiseSalaryOfDepartment(salaryDepartmentRequestDto);
    return RESPONSE_OK;
  }

  @PatchMapping("/{employeeId}")
  public ResponseEntity<StatusResponseDto> updateEmployeeInformation(@PathVariable long employeeId, @RequestBody
      EmployeeUpdateDto employeeUpdateDto) {
    employeeService.updateEmployeeImformation(employeeId, employeeUpdateDto);
    return RESPONSE_OK;
  }
}
