package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    Passenger findById(long id);
    List<Passenger> findAllByFirstName(String firstName);
    List<Passenger> findAllByLastName(String lastName);
    List<Passenger> findAllByBirthDate(Date birthDate);
}
