package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.AirPlaneDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.AirPlaneServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/airPlane")
@RestController
@Api(value = "Airplane API's")
public class AirPlaneController {

    private final AirPlaneServiceImpl airPlaneServiceImpl;

    public AirPlaneController(AirPlaneServiceImpl airPlaneServiceImpl){
        this.airPlaneServiceImpl=airPlaneServiceImpl;
    }

    @ApiOperation(value = "GET AIRPLANE", response = AirPlaneDto.class)
    @GetMapping("/{id}")
    public AirPlaneDto findById(@PathVariable("id") Long id){
        return airPlaneServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE AIRPLANE", response = AirPlaneDto.class)
    @PostMapping("/save")
    public AirPlaneDto save(@RequestBody AirPlaneDto airPlaneDto){
        return airPlaneServiceImpl.save(airPlaneDto);
    }

    @ApiOperation(value = "DELETE AIRPLANE", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id){
        return airPlaneServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE AIRPLANE", response = AirPlaneDto.class)
    @PutMapping("/update/{id}")
    public AirPlaneDto update(@PathVariable("id") Long id,@RequestBody AirPlaneDto airPlaneDto){
        return airPlaneServiceImpl.update(id,airPlaneDto);
    }
}
