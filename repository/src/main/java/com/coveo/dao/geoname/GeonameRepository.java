package com.coveo.dao.geoname;

import com.coveo.model.geoname.Geoname;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("geonameRepository")
public interface GeonameRepository extends JpaRepository<Geoname, Integer> {
    @Query("SELECT p FROM Geoname p WHERE  lower(p.name) like lower(concat( ?1,'%'))")
    public List<Geoname> getGeonamesbyCity(@Param("q") String city);

}
