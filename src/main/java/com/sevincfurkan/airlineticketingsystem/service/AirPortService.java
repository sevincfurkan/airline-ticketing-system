package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.AirPlaneDto;
import com.sevincfurkan.airlineticketingsystem.dto.AirPortDto;

import java.util.List;

public interface AirPortService {
    AirPortDto findById(Long id);
    AirPortDto finByAirPortName(String airPortName);
    AirPortDto save(AirPortDto airPortDto);
    Boolean delete(Long id);
    AirPortDto update(long id,AirPortDto airPortDto);
}
