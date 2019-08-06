package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.AirPortDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.AirPortServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airPort")
@Api(value = "Airport API's")
public class AirPortController {
    private AirPortServiceImpl airPortServiceImpl;

    public AirPortController(AirPortServiceImpl airPortServiceImpl) {
        this.airPortServiceImpl = airPortServiceImpl;
    }

    @ApiOperation(value = "GET AIRPORT", response = AirPortDto.class)
    @GetMapping("/{id}")
    public AirPortDto findById(@PathVariable("id") Long id) {
        return airPortServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE AIRPORT", response = AirPortDto.class)
    @PostMapping("/save")
    public AirPortDto save(@RequestBody AirPortDto airPortDto) {
        return airPortServiceImpl.save(airPortDto);
    }

    @ApiOperation(value = "DELETE AIRPORT", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return airPortServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE AIRPORT", response = AirPortDto.class)
    @PutMapping("/update/{id}")
    public AirPortDto update(@PathVariable("id") Long id, @RequestBody AirPortDto airPortDto) {
        return airPortServiceImpl.update(id, airPortDto);
    }
}
