package com.coveo.helper;

import com.coveo.model.geoname.Geoname;

import java.util.Comparator;

public class SortbyLatLong implements Comparator<Geoname> {
    private String lat;
    private String longt;
    public SortbyLatLong(String lat, String longt)
    {
        this.lat = lat;
        this.longt = longt;
    }
    public int compare(Geoname o1, Geoname o2) {
        int o1Calc = (int) (o1.getLatitude()-Double.parseDouble(lat) +o1.getLongitude()-Double.parseDouble(longt))*10000;
        int o2Calc = (int) (o2.getLatitude()-Double.parseDouble(lat) +o2.getLongitude()-Double.parseDouble(longt))*10000;
        return Math.abs(o1Calc)-Math.abs(o2Calc);
    }
}
