package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.RotaDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.RotaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rota")
@Api(value = "Rota API's")
public class RotaController {
    private final RotaServiceImpl rotaServiceImpl;

    public RotaController(RotaServiceImpl rotaServiceImpl) {
        this.rotaServiceImpl = rotaServiceImpl;
    }

    @ApiOperation(value = "GET ROTA", response = RotaDto.class)
    @GetMapping("/{id}")
    public RotaDto findById(@PathVariable("id") Long id) {
        return rotaServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE ROTA", response = RotaDto.class)
    @PostMapping("/save")
    public RotaDto save(@RequestBody RotaDto rotaDto) {
        return rotaServiceImpl.save(rotaDto);
    }

    @ApiOperation(value = "DELETE ROTA", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return rotaServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE ROTA", response = RotaDto.class)
    @PutMapping("/update/{id}")
    public RotaDto update(@PathVariable("id") Long id, @RequestBody RotaDto rotaDto) {
        return rotaServiceImpl.update(id, rotaDto);
    }
}
