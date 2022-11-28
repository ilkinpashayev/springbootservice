package com.coveo.data;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;

@Data
public class Geonameobj {

    @CsvBindByPosition(position = 0)
    private String geonameid;

    @CsvBindByPosition(position = 1)
    private String name ;

    @CsvBindByPosition(position = 2)
    private String asciiname;

    @CsvBindByPosition(position = 3)
    private String alternatenames;

    @CsvBindByPosition(position = 4)
    private String latitude;

    @CsvBindByPosition(position = 5)
    private String longitude;

    @CsvBindByPosition(position = 6)
    private String feat_class;

    @CsvBindByPosition(position = 7)
    private String feat_code;

    @CsvBindByPosition(position = 8)
    private String country;

    @CsvBindByPosition(position = 9)
    private String cc2;

    @CsvBindByPosition(position = 10)
    private String admin1;

    @CsvBindByPosition(position = 11)
    private String admin2;

    @CsvBindByPosition(position = 12)
    private String admin3;

    @CsvBindByPosition(position = 13)
    private String admin4;

    @CsvBindByPosition(position = 14)
    private String population;

    @CsvBindByPosition(position = 15)
    private String elevation;

    @CsvBindByPosition(position = 16)
    private String dem;

    @CsvBindByPosition(position = 17)
    private  String  tz;

    @CsvBindByPosition(position = 18)
    private String modification_at;

}

