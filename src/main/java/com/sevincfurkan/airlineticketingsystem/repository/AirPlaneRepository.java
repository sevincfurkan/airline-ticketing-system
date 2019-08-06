package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirPlaneRepository extends JpaRepository<AirPlane, Long> {
    AirPlane findById(long id);
    AirPlane findByAirPlaneName(String airPlaneName);
    List<AirPlane> findAllByAirPlaneModel(String airPlanemodel);
    AirPlane findByCapacity(int capacity);
}
