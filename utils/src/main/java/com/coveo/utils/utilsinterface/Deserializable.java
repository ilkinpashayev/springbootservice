package com.coveo.utils.utilsinterface;

import com.coveo.data.Geonameobj;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public interface Deserializable {
    public List<Geonameobj> geonames(String filename) throws IOException;
}
