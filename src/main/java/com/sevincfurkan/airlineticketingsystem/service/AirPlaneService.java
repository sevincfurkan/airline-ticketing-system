package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.AirPlaneDto;
import com.sevincfurkan.airlineticketingsystem.dto.AirPortDto;
import com.sevincfurkan.airlineticketingsystem.entity.AirPlane;

import java.util.List;

public interface AirPlaneService {
    AirPlaneDto findById(Long id);
    AirPlaneDto findByAirPlaneName(String airPlaneName);
    AirPlaneDto save(AirPlaneDto airPlaneDto);
    Boolean delete(Long id);
    AirPlaneDto update(Long id,AirPlaneDto airPlaneDto);
}
