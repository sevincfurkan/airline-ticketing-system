package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.PassengerDto;
import com.sevincfurkan.airlineticketingsystem.dto.PassengerTypeDto;

import java.util.Date;
import java.util.List;

public interface PassengerService {
    PassengerDto findById(Long id);
    List<PassengerDto> findAllByFirstName(String firstName);
    List<PassengerDto> findAllByLastName(String lastName);
    List<PassengerDto> findAllByBirthDate(Date date);
    PassengerDto save(PassengerDto passengerDto);
    Boolean delete(Long id);
    PassengerDto update(Long id, PassengerDto passengerDto);
}
