package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.CityDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.CityServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@Api(value = "City API's")
public class CityController {
    private final CityServiceImpl cityServiceImpl;

    public CityController(CityServiceImpl cityServiceImpl) {
        this.cityServiceImpl = cityServiceImpl;
    }

    @ApiOperation(value = "GET CITY", response = CityDto.class)
    @GetMapping("/{id}")
    public CityDto findById(@PathVariable("id") Long id) {
        return cityServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE CITY", response = CityDto.class)
    @PostMapping("/save")
    public CityDto save(@RequestBody CityDto cityDto) {
        return cityServiceImpl.save(cityDto);
    }

    @ApiOperation(value = "DELETE CITY", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return cityServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE CITY", response = CityDto.class)
    @PutMapping("/update/{id}")
    public CityDto update(@PathVariable("id") Long id, @RequestBody CityDto cityDto) {
        return cityServiceImpl.update(id, cityDto);
    }
}
