package com.ecoAndRich.ecoandrich_may_be.domain.department.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "location_id")
  private long id;

  @Column(name = "street_address")
  private String streetAddress;

  @Column(name = "postal_code")
  private String posCode;

  @Column(name = "city")
  private String city;

  @Column(name = "country_id")
  private char countryId;

  @OneToMany(mappedBy = "location")
  private final List<Department> departments = new ArrayList<>();
}
