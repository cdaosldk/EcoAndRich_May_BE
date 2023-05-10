package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class ExchangeRate {

  @Id
  @Column(name = "cur_unit")
  private String curUnit;

  @Column(name = "cur_nm")
  private String curNm;

  private String ttb;

  private String tts;

  @Column(name = "deal_bas_r")
  private String dealBasR;

  private String bkpr;

  @Column(name = "yy_efee_r")
  private String yyEfeeR;

  @Column(name = "ten_dd_efee_r")
  private String tenDdEfeeR;

  @Column(name = "kftc_deal_bas_r")
  private String kftcDealBasR;

  @Column(name = "kftc_bkpr")
  private String kftcBkpr;
}
