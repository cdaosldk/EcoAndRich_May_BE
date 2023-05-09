package com.ecoAndRich.ecoandrich_may_be.domain.department.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String streetAddress;

  private String posCode;

  private String city;

  private char countryId;

  @Builder
  public Location(String streetAddress, String posCode, String city, char countryId) {
    this.streetAddress = streetAddress;
    this.posCode = posCode;
    this.city = city;
    this.countryId = countryId;
  }

  @OneToMany(mappedBy = "location")
  private final List<Department> department = new ArrayList<>();
}
