package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.AirPortDto;
import com.sevincfurkan.airlineticketingsystem.dto.CityDto;
import com.sevincfurkan.airlineticketingsystem.dto.CountryDto;

import java.util.List;

public interface CityService {
    CityDto findById(Long id);
    CityDto findByCityName(String cityName);
    CityDto save(CityDto cityDto);
    CityDto update(Long id,CityDto cityDto);
    Boolean delete(Long id);
}
