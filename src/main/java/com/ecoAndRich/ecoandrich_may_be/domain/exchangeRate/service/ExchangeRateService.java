package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.service;

import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.dto.ExchangeRateResponseDto;

public interface ExchangeRateService {

  public ExchangeRateResponseDto getExchangeRate(String searchDate, String curUnit);
}
