package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
    City findById(long id);
    City findByCityName(String cityName);
}
