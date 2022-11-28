package com.coveo.controller.geoname;

import com.coveo.data.Geonamedto;
import com.coveo.model.geoname.Geoname;
import com.coveo.service.geoname.GeonameService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class GeonameController  {



    @Autowired
    private GeonameService geonameService;

    public GeonameController(GeonameService geonameService) {
        this.geonameService = geonameService;
    }
    @GetMapping("/suggestions")
    public List<Geonamedto> getGeonames(@RequestParam @NotNull @NotBlank String q, @RequestParam(required = false)  String  latitude, @RequestParam(required = false)  String longitude){
        if (latitude==null || longitude ==null)
        {
            return geonameService.getGeonamesByCity(q);
        }
        return geonameService.getGeonamesByScoring(q,latitude,longitude);

    }
}
