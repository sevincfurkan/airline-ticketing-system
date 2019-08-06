package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.FlyDto;
import com.sevincfurkan.airlineticketingsystem.dto.RotaDto;

import java.util.List;

public interface FlyService {
    FlyDto findById(Long id);
    List<FlyDto> findAllByRotaName(String rotaDto);
    FlyDto save(FlyDto flyDto);
    Boolean delete(Long id);
    FlyDto update(Long id, FlyDto flyDto);
}
