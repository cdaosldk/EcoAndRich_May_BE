package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExchangeRateResponseDto {

  private String curNm;

  private String ttb;

  private String tts;

  private String dealBasR;

  private String bkpr;

  private String yyEfeeR;

  private String tenDdEfeeR;

  private String kftcDealBasR;

  private String kftcBkpr;

  @Builder
  public ExchangeRateResponseDto(String curNm, String ttb, String tts,
      String dealBasR, String bkpr, String yyEfeeR, String tenDdEfeeR, String kftcDealBasR,
      String kftcBkpr) {
    this.curNm = curNm;
    this.ttb = ttb;
    this.tts = tts;
    this.dealBasR = dealBasR;
    this.bkpr = bkpr;
    this.yyEfeeR = yyEfeeR;
    this.tenDdEfeeR = tenDdEfeeR;
    this.kftcDealBasR = kftcDealBasR;
    this.kftcBkpr = kftcBkpr;
  }
}
