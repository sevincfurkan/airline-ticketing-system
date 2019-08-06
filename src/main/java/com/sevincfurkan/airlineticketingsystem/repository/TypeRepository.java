package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findById(long id);
    List<Type> findAllByType(String type);
    List<Type> findAllByTicketList(String ticket);
}
