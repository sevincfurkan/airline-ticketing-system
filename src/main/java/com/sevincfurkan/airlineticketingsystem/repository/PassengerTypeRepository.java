package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.PassengerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTypeRepository extends JpaRepository<PassengerType,Long> {
    PassengerType findById(long id);
    PassengerType findAllByPassengerType(String PassengerType);
}
