package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto findById(Long id);
    List<RoleDto> findAllByRoleName(String roleDto);
    RoleDto save(RoleDto roleDto);
    Boolean delete(Long id);
    RoleDto update(Long id,RoleDto roleDto);
}
