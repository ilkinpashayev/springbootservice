package com.coveo.model.geoname;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigInteger;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Geoname {

    @Id
    private int geonameid;
    @Column(length=200)
    private String name ;
    private double latitude;
    private double longitude;
    @Column(length = 2)
    private String country;
    @Column(length = 60)
    private String cc2;
    private String admin1;

}
