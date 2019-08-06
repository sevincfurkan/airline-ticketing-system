package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.TypeDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.TypeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController("/types")
@Api(value = "TYPe API's")
public class TypeController {
    private final TypeServiceImpl typeServiceImpl;

    public TypeController(TypeServiceImpl typeServiceImpl) {
        this.typeServiceImpl = typeServiceImpl;
    }

    @ApiOperation(value = "GET TICKET",response = TypeDto.class)
    @GetMapping("/{id}")
    public TypeDto findById(@PathVariable("id") Long id) {
        return typeServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE TYPE",response = TypeDto.class)
    @PostMapping("/save")
    public TypeDto save(@RequestBody TypeDto typeDto) {
        return typeServiceImpl.save(typeDto);
    }
    @ApiOperation(value = "UPDATE TYPE",response = TypeDto.class)
    @PutMapping("/update")
    public TypeDto update(@PathVariable Long id, @RequestBody TypeDto typeDto) {
        return typeServiceImpl.update(id, typeDto);
    }

    @ApiOperation(value = "DELETE TYPE",response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return typeServiceImpl.delete(id);
    }
}
