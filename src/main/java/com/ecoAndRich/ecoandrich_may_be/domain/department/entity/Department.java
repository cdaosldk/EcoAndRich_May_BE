package com.ecoAndRich.ecoandrich_may_be.domain.department.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String depName;

  @Builder
  public Department(String depName) {
    this.depName = depName;
  }

  @ManyToOne
  @JoinColumn(name = "location_id")
  private final Location location = new Location();
}
