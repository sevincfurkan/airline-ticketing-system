package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.PassengerDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.PassengerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
@Api(value = "Passenger API's")
public class PassengerController {
    private final PassengerServiceImpl passengerServiceImpl;

    public PassengerController(PassengerServiceImpl passengerServiceImpl){
        this.passengerServiceImpl=passengerServiceImpl;
    }

    @ApiOperation(value = "GET PASSENGER", response = PassengerDto.class)
    @GetMapping("/{id}")
    public PassengerDto findById(@PathVariable("id") Long id) {
        return passengerServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE PASSENGER", response = PassengerDto.class)
    @PostMapping("/save")
    public PassengerDto save(@RequestBody PassengerDto passengerDto) {
        return passengerServiceImpl.save(passengerDto);
    }

    @ApiOperation(value = "DELETE PASSENGER", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return passengerServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE PASSENGER", response = PassengerDto.class)
    @PutMapping("/update/{id}")
    public PassengerDto update(@PathVariable("id") Long id, @RequestBody PassengerDto passengerDto) {
        return passengerServiceImpl.update(id, passengerDto);
    }
}
