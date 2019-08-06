package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.CountryDto;
import com.sevincfurkan.airlineticketingsystem.dto.FlyDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.FlyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fly")
@Api(value = "Fly API's")
public class FlyController {
    private final FlyServiceImpl flyServiceImpl;

    public FlyController(FlyServiceImpl flyServiceImpl){
        this.flyServiceImpl=flyServiceImpl;
    }

    @ApiOperation(value = "GET FLY", response = FlyDto.class)
    @GetMapping("/{id}")
    public FlyDto findById(@PathVariable("id") Long id) {
        return flyServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE FLY", response = FlyDto.class)
    @PostMapping("/save")
    public FlyDto save(@RequestBody FlyDto flyDto) {
        return flyServiceImpl.save(flyDto);
    }

    @ApiOperation(value = "DELETE FLY", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return flyServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE FLY", response = FlyDto.class)
    @PutMapping("/update/{id}")
    public FlyDto update(@PathVariable("id") Long id, @RequestBody FlyDto flyDto) {
        return flyServiceImpl.update(id, flyDto);
    }
}
