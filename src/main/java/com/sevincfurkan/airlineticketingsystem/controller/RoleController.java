package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.RoleDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.RoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Api(value = "Role API's")
public class RoleController {
    private final RoleServiceImpl roleServiceImpl;

    public RoleController(RoleServiceImpl roleServiceImpl){
        this.roleServiceImpl=roleServiceImpl;
    }

    @ApiOperation(value = "GET ROLE", response = RoleDto.class)
    @GetMapping("/{id}")
    public RoleDto findById(@PathVariable("id") Long id) {
        return roleServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE ROLE", response = RoleDto.class)
    @PostMapping("/save")
    public RoleDto save(@RequestBody RoleDto roleDto) {
        return roleServiceImpl.save(roleDto);
    }

    @ApiOperation(value = "DELETE ROLE", response = Boolean.class)
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return roleServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE ROLE", response = RoleDto.class)
    @PutMapping("/update/{id}")
    public RoleDto update(@PathVariable("id") Long id, @RequestBody RoleDto roleDto) {
        return roleServiceImpl.update(id, roleDto);
    }
}
