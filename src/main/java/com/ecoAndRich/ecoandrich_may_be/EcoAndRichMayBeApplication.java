package com.ecoAndRich.ecoandrich_may_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EcoAndRichMayBeApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcoAndRichMayBeApplication.class, args);
  }

}
