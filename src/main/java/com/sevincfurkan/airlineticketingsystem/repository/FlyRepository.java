package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.Fly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlyRepository extends JpaRepository<Fly,Long> {
    Fly findById(long id);
    Fly findAllByRotaName(String rota);
}
