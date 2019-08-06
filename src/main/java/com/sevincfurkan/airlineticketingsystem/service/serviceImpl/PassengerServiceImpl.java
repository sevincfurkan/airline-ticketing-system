package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.PassengerDto;
import com.sevincfurkan.airlineticketingsystem.entity.Passenger;
import com.sevincfurkan.airlineticketingsystem.repository.PassengerRepository;
import com.sevincfurkan.airlineticketingsystem.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository,ModelMapper modelMapper){
        this.passengerRepository=passengerRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public PassengerDto findById(Long id) {
        Passenger passenger=passengerRepository.getOne(id);
        return modelMapper.map(passenger,PassengerDto.class);
    }

    @Override
    public List<PassengerDto> findAllByFirstName(String firstName) {
        List<Passenger> passengerList=passengerRepository.findAllByFirstName(firstName);
        Type listType=new TypeToken<List<PassengerDto>>(){}.getType();
        return modelMapper.map(passengerList,listType);
    }

    @Override
    public List<PassengerDto> findAllByLastName(String lastName) {
        List<Passenger> passengerList=passengerRepository.findAllByLastName(lastName);
        Type listType=new TypeToken<List<PassengerDto>>(){}.getType();
        return modelMapper.map(passengerList,listType);
    }

    @Override
    public List<PassengerDto> findAllByBirthDate(Date date) {
        List<Passenger> passengerList=passengerRepository.findAllByBirthDate((java.sql.Date) date);
        Type listType=new TypeToken<List<PassengerDto>>(){}.getType();
        return modelMapper.map(passengerList,listType);
    }

    @Override
    public PassengerDto save(PassengerDto passengerDto) {
        Passenger passenger=modelMapper.map(passengerDto,Passenger.class);
        passenger=passengerRepository.save(passenger);
        return modelMapper.map(passenger,PassengerDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        Passenger passenger=passengerRepository.getOne(id);
        if(passenger==null){
            return false;
        }else{
            passengerRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public PassengerDto update(Long id, PassengerDto passengerDto) {
        return null;
    }
}
