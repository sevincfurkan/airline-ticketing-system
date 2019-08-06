package com.sevincfurkan.airlineticketingsystem.service;

import com.sevincfurkan.airlineticketingsystem.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    Boolean delete(Long id);
    UserDto findById(Long id);
    List<UserDto> findAllByFirstName(String firstName);
    List<UserDto> findAllByLastName(String lastName);
    UserDto findByUserName(String userName);
    UserDto findByMail(String mail);
    UserDto update(Long id,UserDto userDto);
}
