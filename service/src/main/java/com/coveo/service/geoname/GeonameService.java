package com.coveo.service.geoname;

import com.coveo.dao.geoname.GeonameRepository;
import com.coveo.data.Geonamedto;
import com.coveo.data.Geonameobj;
import com.coveo.helper.SortbyLatLong;
import com.coveo.model.geoname.Geoname;
import com.coveo.states.canadastates;
import com.coveo.utils.utilsinterface.Deserializable;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeonameService {

    @Autowired
    @Qualifier("geonameRepository")
    private GeonameRepository geonameRepository;

    @Autowired
    private Deserializable deserializable;


    @PostConstruct
    public void initGeonames() throws IOException {
      // System.out.println(canadastates.valueOf("Ontario").getState());


        List<Geonameobj> geonameobjlist  = deserializable.geonames("C:\\Ilkin\\Projects\\Java\\city-suggestion-system\\cities_canada-usa.tsv");
        Geonameobj record;

        for (Geonameobj element :geonameobjlist)
        {
            if (element.getGeonameid().equals("id"))
            {
                continue;
            }
            try {
                geonameRepository.save(
                        new Geoname(Integer.parseInt(element.getGeonameid()),
                                element.getName(),
                                Double.parseDouble(element.getLatitude()),
                                Double.parseDouble(element.getLongitude()),
                                element.getCountry(),
                                element.getCc2(),
                                element.getAdmin1()
                        ));
            }
            catch(Exception e)
            {
            }

        }
    }

    public List<Geonamedto> getGeonamesByCity(String city) {
        return geonameRepository.getGeonamesbyCity(city)
                .stream()
                .map(x->this.convertDataIntoDTO(x,null, null))
                .collect(Collectors.toList());
    }

    private Geonamedto convertDataIntoDTO(Geoname geoname,String lat,String longt) {
        Geonamedto dto = new Geonamedto();
        String name;
        if (geoname.getCountry().equals("CA"))
            name = geoname.getName()+", "+canadastates.valueOf(geoname.getCountry()+geoname.getAdmin1()).getState()+", Canada";
        else
            name = geoname.getName()+", "+geoname.getAdmin1()+", USA";

        dto.setName(name);
        dto.setLatitude(geoname.getLatitude());
        dto.setLongitude(geoname.getLongitude());
       if (lat==null)
        dto.setScore(0);
       else
       {
           int score = (int) (geoname.getLatitude()-Double.parseDouble(lat) +geoname.getLongitude()-Double.parseDouble(longt))*10000;
           dto.setScore(score);
       }

        return  dto;

    }

    public List<Geonamedto> getGeonamesByScoring(String city,String lat,String longt) {
        List<Geoname> cities = geonameRepository.getGeonamesbyCity(city);
        SortbyLatLong sortbyLatLong =  new SortbyLatLong(lat,longt);

        Collections.sort(cities, sortbyLatLong);

        return cities.stream()
                .map(x->this.convertDataIntoDTO(x, lat,longt))
                .collect(Collectors.toList());

    }


}
