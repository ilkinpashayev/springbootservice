package com.coveo.utils.Impl;

import com.coveo.data.Geonameobj;
import com.coveo.utils.utilsinterface.Deserializable;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class DeserializeFile implements Deserializable  {
    @Override
    public List<Geonameobj> geonames(String filename) throws IOException {

        List<Geonameobj> beans = new CsvToBeanBuilder(new FileReader(filename))
                .withIgnoreQuotations(true)
                .withIgnoreLeadingWhiteSpace(true)
                .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                .withSeparator('\t')
                .withType(Geonameobj.class)
                .build()
                .parse();
        return beans;
    }
}
