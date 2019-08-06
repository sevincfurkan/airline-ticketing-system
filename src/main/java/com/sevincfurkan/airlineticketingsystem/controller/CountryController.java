package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.CityDto;
import com.sevincfurkan.airlineticketingsystem.dto.CountryDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.CountryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@Api(value = "Country API's")
public class CountryController {
    private final CountryServiceImpl countryServiceImpl;

    public CountryController(CountryServiceImpl countryServiceImpl) {
        this.countryServiceImpl = countryServiceImpl;
    }

    @ApiOperation(value = "GET COUNTRY", response = CountryDto.class)
    @GetMapping("/{id}")
    public CountryDto findById(@PathVariable("id") Long id) {
        return countryServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE COUNTRY", response = CountryDto.class)
    @PostMapping("/save")
    public CountryDto save(@RequestBody CountryDto countryDto) {
        return countryServiceImpl.save(countryDto);
    }

    @ApiOperation(value = "DELETE COUNTRY", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return countryServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE COUNTRY", response = CountryDto.class)
    @PutMapping("/update/{id}")
    public CountryDto update(@PathVariable("id") Long id, @RequestBody CountryDto countryDto) {
        return countryServiceImpl.update(id, countryDto);
    }
}
