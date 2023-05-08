package com.ecoAndRich.ecoandrich_may_be.util;

import com.ecoAndRich.ecoandrich_may_be.enums.ResponseMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ecoAndRich.ecoandrich_may_be.dto.StatusResponseDto;

public class HttpResponseEntity {

  public static final ResponseEntity<StatusResponseDto> RESPONSE_OK = ResponseEntity
      .status(HttpStatus.OK).body(StatusResponseDto.valueOf(
          ResponseMessages.SUCCESS));

  public static final ResponseEntity<StatusResponseDto> RESPONSE_CREATED = ResponseEntity.status(
      HttpStatus.CREATED).body(StatusResponseDto.valueOf(ResponseMessages.CREATED_SUCCESS));

  public static final ResponseEntity<StatusResponseDto> RESPONSE_DELETE = ResponseEntity.status(
      HttpStatus.NO_CONTENT).body(StatusResponseDto.valueOf(ResponseMessages.DELETE_SUCCESS));

}
