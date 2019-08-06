package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto findById(Long id);
    List<TicketDto> findAllByAirPlaneName(String airPlaneDto);
    List<TicketDto> findAllByTypeName(String type);
    TicketDto save(TicketDto ticketDto);
    Boolean delete(Long id);
    TicketDto update(Long id,TicketDto ticketDto);
}
