package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RotaRepository extends JpaRepository<Rota,Long> {
    Rota findById(long id);
    List<Rota> findAllByTakeOff(Date takaOff);
    List<Rota> findAllByArrival(Date arrival);
    Rota findByDLat(String dLat);
    Rota findByDLong(String dLong);
}
