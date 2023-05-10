package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.controller;

import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.dto.ExchangeRateRequestDto;
import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.dto.ExchangeRateResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.service.ExchangeRateService;
import com.ecoAndRich.ecoandrich_may_be.util.SetHttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchangeRate")
public class ExchangeRateController {

  private final ExchangeRateService exchangeRateService;

  private final SetHttpHeaders setHttpHeaders;

  @GetMapping
  public ResponseEntity<ExchangeRateResponseDto> getExchangeRate(@RequestBody ExchangeRateRequestDto exchangeRateRequestDto) {
    exchangeRateService.getExchangeRate(exchangeRateRequestDto.getSearchDate(), exchangeRateRequestDto.getCurUnit());
    return ResponseEntity.ok().headers(setHttpHeaders.setHeaderTypeJson()).body(exchangeRateService.getExchangeRate(exchangeRateRequestDto.getSearchDate(), exchangeRateRequestDto.getCurUnit()));
  }
}