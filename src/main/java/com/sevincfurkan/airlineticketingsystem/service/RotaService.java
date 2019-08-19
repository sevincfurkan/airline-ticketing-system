package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.AirPortDto;
import com.sevincfurkan.airlineticketingsystem.dto.FlyDto;
import com.sevincfurkan.airlineticketingsystem.dto.RotaDto;

import java.sql.Date;
import java.util.List;

public interface RotaService {
    RotaDto findById(Long id);
    List<RotaDto> findAllByTakeOff(Date takeOff);
    List<RotaDto> findAllByArrival(Date arrival);
    RotaDto save(RotaDto rotaDto);
    Boolean delete(Long id);
    RotaDto update(Long id,RotaDto rotaDto);
    double showDistance(RotaDto rotaDto);
}
