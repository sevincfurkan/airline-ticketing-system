package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Api(value = "User API's")
@Slf4j
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @ApiOperation(value = "GET USER API", response = UserDto.class)
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        log.info("UserController -> GetById -> PARAM ");
        log.debug("UserController -> GetById -> PARAM "+id);
        return userServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE USER", response = UserDto.class)
    @PostMapping(path = "/save")
    public UserDto save(@RequestBody UserDto userDto) {
        log.info("UserController -> Save -> PARAM");
        log.debug("UserController -> Save -> PARAM "+ userDto);
        return userServiceImpl.save(userDto);
    }

    @ApiOperation(value = "DELETE USER", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        log.info("UserController -> Save -> PARAM");
        return userServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE USER", response = UserDto.class)
    @PutMapping(path = "/update")
    public UserDto update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        log.info("UserController -> Save -> PARAM");
        log.debug("UserController -> Save -> PARAM "+ userDto);
        return userServiceImpl.update(id, userDto);
    }

}
