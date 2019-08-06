package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.City;
import com.sevincfurkan.airlineticketingsystem.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {
    Country findById(long id);
    Country findByCountryName(String countryName);
}
