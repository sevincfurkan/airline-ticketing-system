package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirPortRepository extends JpaRepository<AirPort,Long> {
    AirPort findById(long id);
    AirPort findByAirPortName(String airPortName);
}
