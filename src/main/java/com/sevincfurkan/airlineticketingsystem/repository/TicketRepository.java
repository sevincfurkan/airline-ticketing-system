package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.AirPlane;
import com.sevincfurkan.airlineticketingsystem.entity.Ticket;
import com.sevincfurkan.airlineticketingsystem.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket findById(long id);
    List<Ticket> findAllByAirPlaneName(String airPlane);
    List<Ticket> findAllByTypeName(String type);
}
