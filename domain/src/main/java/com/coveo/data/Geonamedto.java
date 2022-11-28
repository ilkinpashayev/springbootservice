package com.coveo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geonamedto {
    private String name ;
    private Double latitude ;
    private Double longitude ;
    private int score ;
}
