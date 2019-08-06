package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.TicketDto;
import com.sevincfurkan.airlineticketingsystem.entity.Ticket;
import com.sevincfurkan.airlineticketingsystem.repository.TicketRepository;
import com.sevincfurkan.airlineticketingsystem.service.TicketService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;


    public TicketServiceImpl(TicketRepository ticketRepository,ModelMapper modelMapper){
        this.ticketRepository=ticketRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public TicketDto findById(Long id) {
        Ticket ticket=ticketRepository.getOne(id);
        return modelMapper.map(ticket,TicketDto.class);
    }

    @Override
    public List<TicketDto> findAllByAirPlaneName(String airPlaneDto) {
        List<Ticket> ticketList=ticketRepository.findAllByAirPlaneName(airPlaneDto);
        java.lang.reflect.Type listType = new TypeToken<List<TicketDto>>(){}.getType();
        return modelMapper.map(ticketList,listType);
    }

    @Override
    public List<TicketDto> findAllByTypeName(String type) {
        List<Ticket> ticketList=ticketRepository.findAllByTypeName(type);
        Type lisType=new TypeToken<List<TicketDto>>(){}.getType();
        return modelMapper.map(ticketList,lisType);
    }

    @Override
    public TicketDto save(TicketDto ticketDto) {
        Ticket ticket=modelMapper.map(ticketDto,Ticket.class);
        ticket=ticketRepository.save(ticket);
        return modelMapper.map(ticket,TicketDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        Ticket ticket=ticketRepository.getOne(id);
        if(ticket==null){
            throw new IllegalArgumentException("Ticket already delete:"+id);
        }
        else{
            ticketRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public TicketDto update(Long id, TicketDto ticketDto) {
        Ticket ticket=ticketRepository.getOne(id);
        if(ticket==null){
            throw new IllegalArgumentException("Ticket does not exist");
        }
        ticket=modelMapper.map(ticketDto,Ticket.class);
        ticket.setAirPlaneName(ticket.getAirPlaneName());
        ticket.setTypeName(ticket.getTypeName());
        return modelMapper.map(ticket,TicketDto.class);
    }
}
