package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.CityDto;
import com.sevincfurkan.airlineticketingsystem.dto.CountryDto;

import java.util.List;

public interface CountryService {
    CountryDto findById(Long id);
    CountryDto findByCountryName(String countryName);
    CountryDto save(CountryDto countryDto);
    Boolean delete(Long id);
    CountryDto update(Long id, CountryDto countryDto);
}
