package com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.service;

import com.ecoAndRich.ecoandrich_may_be.domain.exchangeRate.repository.ExchangeRateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globalorder.btrips.ext.domain.ExchangeRateEntity;
import com.globalorder.btrips.ext.dto.ExchangeRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateServiceImpl {

  private final ExchangeRateRepository exchangeRateRepository;

  private OkHttpClient okHttpClient;

  private static final ObjectMapper objectMapper = new ObjectMapper();

  private final String EXCHANGE_RATE_URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
  private final String DATE_FORMATTER = "yyyyMMdd";
  private final String DATA = "AP01";
  private final String AUTHKEY = "H9TGLNKNDT7C1MhsVpY7JrGoW6brt2MX";


  public ExchangeRateEntity saveExchangeRate(LocalDateTime kst) throws Exception {

    LocalDateTime utc = LocalDateTime.now(ZoneOffset.UTC);

    String url = createRequestUrl(kst);

    okHttpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .url(url)
        .build();
    Response response = okHttpClient.newCall(request).execute();

    if (!response.isSuccessful()) {
      log.error("ExchangeRate::: " + response.code() + "/" + response.body().string());
      throw new Exception();
    }

    String responseBody = response.body().string();

    if (notWorkingDay((responseBody))) {
      return exchangeRateRepository.findById("USD").orElse(null);
    }

    //JSON to List<Object>
    List<ExchangeRate.Response> exchangeRates = Arrays.asList(objectMapper.readValue(responseBody, ExchangeRate.Response[].class));

    ExchangeRate.Response USD = getUSD(exchangeRates);

    log.info("ExchangeRate::: " + USD);

    ExchangeRateEntity exchangeRateEntity = ExchangeRateEntity.builder()
        .curNm(USD.getCurUnit())
        .krw(parseToDecimal(USD.getDealBasR()))
        .updatedTime(utc).build();

    return exchangeRateRepository.save(exchangeRateEntity);
  }

  //ExchangeEntity 환율 정보
  public ExchangeRateEntity findExchangeRate() {
    return exchangeRateRepository.findById("USD").orElseThrow(() -> new RuntimeException("환율정보가 없습니다."));
  }

  //비영업일 체크
  private boolean notWorkingDay(String responseBody) {
    return responseBody.equals("[]");
  }

  //환율 콤마 제거
  protected BigDecimal parseToDecimal(String dealBasR) {
    int commaPosition = dealBasR.indexOf(',');
    String removeCommaDealBasR = dealBasR.substring(0, commaPosition) + dealBasR.substring(commaPosition + 1);
    return new BigDecimal(removeCommaDealBasR);
  }

  private ExchangeRate.Response getUSD(List<ExchangeRate.Response> exchangeRates) {
    //TODO: 리팩토링 if문 중첩 없애기
    for (ExchangeRate.Response ex : exchangeRates) {
      if (ex.getCurUnit().equals("USD")) {
        return ex;
      }
    }
    return new ExchangeRate.Response();
  }

  //수출입은행 비영업일 때 이전 영업일 데이터 요청
  private String createRequestUrl(LocalDateTime workingDay) {
    StringBuilder urlBuilder = new StringBuilder();
    urlBuilder.append(EXCHANGE_RATE_URL);
    urlBuilder.append("?authkey=");
    urlBuilder.append(AUTHKEY);
    urlBuilder.append("&searchdate=");
    urlBuilder.append(workingDay.format(DateTimeFormatter.ofPattern(DATE_FORMATTER)));
    urlBuilder.append("&data=");
    urlBuilder.append(DATA);
    return urlBuilder.toString();
  }
}
