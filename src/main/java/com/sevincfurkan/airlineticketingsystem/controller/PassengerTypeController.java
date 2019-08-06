package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.PassengerTypeDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.PassengerTypeServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passengerType")
@Api(value = "Passenger Type API's")
public class PassengerTypeController {
    private PassengerTypeServiceImpl passengerTypeServiceImpl;

    public PassengerTypeController(PassengerTypeServiceImpl passengerTypeServiceImpl) {
        this.passengerTypeServiceImpl = passengerTypeServiceImpl;
    }

    @ApiOperation(value = "GET PASSENGER TYPE", response = PassengerTypeDto.class)
    @GetMapping("/{id}")
    public PassengerTypeDto findById(@PathVariable("id") Long id) {
        return passengerTypeServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE PASSENGER TYPE", response = PassengerTypeDto.class)
    @PostMapping("/save")
    public PassengerTypeDto save(@RequestBody PassengerTypeDto passengerTypeDto) {
        return passengerTypeServiceImpl.save(passengerTypeDto);
    }

    @ApiOperation(value = "DELETE PASSENGER TYPE", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return passengerTypeServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE PASSENGER TYPE", response = PassengerTypeDto.class)
    @PutMapping("/update/{id}")
    public PassengerTypeDto update(@PathVariable("id") Long id, @RequestBody PassengerTypeDto passengerTypeDto) {
        return passengerTypeServiceImpl.update(id, passengerTypeDto);
    }
}
