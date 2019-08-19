package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.TicketDto;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.TicketServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@Api(value = "Ticket API's")
public class TicketController {
    private final TicketServiceImpl ticketServiceImpl;

    public TicketController(TicketServiceImpl ticketServiceImpl) {
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @ApiOperation(value = "GET TICKET", response = TicketDto.class)
    @GetMapping("/{id}")
    public TicketDto findById(@PathVariable("id") Long id) {
        return ticketServiceImpl.findById(id);
    }

    @ApiOperation(value = "SAVE TICKET", response = TicketDto.class)
    @PostMapping("/save")
    public TicketDto save(@RequestBody TicketDto ticketDto) {
        return ticketServiceImpl.save(ticketDto);
    }

    @ApiOperation(value = "DELETE TICKET", response = Boolean.class)
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return ticketServiceImpl.delete(id);
    }

    @ApiOperation(value = "UPDATE TICKET", response = TicketDto.class)
    @PutMapping("/update/{id}")
    public TicketDto update(@PathVariable("id") Long id, @RequestBody TicketDto ticketDto) {
        return ticketServiceImpl.update(id, ticketDto);
    }
}
