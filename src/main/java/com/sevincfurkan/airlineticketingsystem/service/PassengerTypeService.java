package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.PassengerTypeDto;

import java.util.List;

public interface PassengerTypeService {
    PassengerTypeDto findById(Long id);
    List<PassengerTypeDto> findAllByPassengerType(String passengerType);
    PassengerTypeDto save(PassengerTypeDto passengerTypeDto);
    Boolean delete(Long id);
    PassengerTypeDto update(Long id,PassengerTypeDto passengerTypeDto);
}
