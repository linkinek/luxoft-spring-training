package com.example.demo.dao;

import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CountryDao extends CrudRepository<Country, Integer> {

    public static final String[][] COUNTRY_INIT_DATA = {{"Australia", "AU"},
            {"Canada", "CA"}, {"France", "FR"}, {"Hong Kong", "HK"},
            {"Iceland", "IC"}, {"Japan", "JP"}, {"Nepal", "NP"},
            {"Russian Federation", "RU"}, {"Sweden", "SE"},
            {"Switzerland", "CH"}, {"United Kingdom", "GB"},
            {"United States", "US"}};

    Iterable<Country> findByNameStartsWith(String name);

    Country findFirstByCodeName(String codeName);

    Country findByName(String name);

    @Transactional
    @Modifying
    @Query("update Country set name = :newCountryName where codeName = :codeName")
    void updateCountryName(@Param("codeName") String codeName, @Param("newCountryName") String newCountryName);
}
