package com.ecoAndRich.ecoandrich_may_be.util;

import com.ecoAndRich.ecoandrich_may_be.dto.StatusResponseDto;
import com.ecoAndRich.ecoandrich_may_be.enums.ResponseMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponseEntity {

  public static final ResponseEntity<StatusResponseDto> RESPONSE_OK = ResponseEntity
      .status(HttpStatus.OK).body(StatusResponseDto.valueOf(
          ResponseMessages.SUCCESS));
}
