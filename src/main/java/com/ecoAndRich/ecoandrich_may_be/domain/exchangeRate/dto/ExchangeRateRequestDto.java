package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExchangeRateRequestDto {

  private String searchDate;

  private String curUnit;

  public ExchangeRateRequestDto(String searchDate, String curUnit) {
    this.searchDate = searchDate;
    this.curUnit = curUnit;
  }
}
