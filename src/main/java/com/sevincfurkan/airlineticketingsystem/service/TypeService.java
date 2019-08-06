package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.TypeDto;

import java.util.List;

public interface TypeService {
    TypeDto save(TypeDto typeDto);
    Boolean delete(Long id);
    TypeDto findById(Long id);
    List<TypeDto> findAllByTypeName(String type);
    TypeDto update(Long id,TypeDto typeDto);
}
