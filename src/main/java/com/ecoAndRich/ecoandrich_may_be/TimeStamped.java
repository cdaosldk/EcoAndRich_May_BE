package com.ecoAndRich.ecoandrich_may_be;

import java.time.LocalDate;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeStamped {

  @CreatedDate
  private LocalDate hireDate;
}
