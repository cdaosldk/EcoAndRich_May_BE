package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.controller;

import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchangeRate")
public class ExchangeRateController {

  private final ExchangeRateService exchangeRateService;


}
