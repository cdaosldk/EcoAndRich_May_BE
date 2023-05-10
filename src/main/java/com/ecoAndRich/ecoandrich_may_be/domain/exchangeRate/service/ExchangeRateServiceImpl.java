package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.service;

import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.dto.ExchangeRateResponseDto;
import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.entity.ExchangeRate;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

  @Override
  @Transactional(readOnly = true)
  public ExchangeRateResponseDto getExchangeRate(String searchDate, String curUnit){
    Gson gson = new Gson();

    ExchangeRate exchangeRate = gson.fromJson(getJsonReponse(searchDate, curUnit), ExchangeRate.class);

    return ExchangeRateResponseDto.builder()
        .curNm(exchangeRate.getCurNm())
        .ttb(exchangeRate.getTtb())
        .tts(exchangeRate.getTts())
        .dealBasR(exchangeRate.getDealBasR())
        .bkpr(exchangeRate.getBkpr())
        .yyEfeeR(exchangeRate.getYyEfeeR())
        .tenDdEfeeR(exchangeRate.getTenDdEfeeR())
        .kftcDealBasR(exchangeRate.getKftcDealBasR())
        .kftcBkpr(exchangeRate.getKftcBkpr())
        .build();
  }

  private String getJsonReponse(String searchDate, String curUnit) {
    String jsonResponse = null;
    try {
      String EXCHANGE_RATE_URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=qcJXI7eDvlXgmlVwAPkwymkXMAv2GTRs&data=AP01";
      URL url = new URL(EXCHANGE_RATE_URL + "&" + searchDate + "&" + curUnit);
      HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
      httpURLConnection.setRequestMethod("GET");

      if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuffer response = new StringBuffer();

        while (reader.readLine() != null) {
          response.append(reader.readLine());
        }
        reader.close();
        jsonResponse = response.toString();
      }
      httpURLConnection.disconnect();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return jsonResponse;
  }
}
