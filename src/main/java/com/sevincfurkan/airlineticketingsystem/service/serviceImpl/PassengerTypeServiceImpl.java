package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.PassengerTypeDto;
import com.sevincfurkan.airlineticketingsystem.entity.Passenger;
import com.sevincfurkan.airlineticketingsystem.entity.PassengerType;
import com.sevincfurkan.airlineticketingsystem.repository.PassengerTypeRepository;
import com.sevincfurkan.airlineticketingsystem.service.PassengerTypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class PassengerTypeServiceImpl implements PassengerTypeService {
    private final PassengerTypeRepository passengerTypeRepository;
    private final ModelMapper modelMapper;

    public PassengerTypeServiceImpl(PassengerTypeRepository passengerTypeRepository,ModelMapper modelMapper){
        this.passengerTypeRepository=passengerTypeRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public PassengerTypeDto findById(Long id) {
        PassengerType passengerType=passengerTypeRepository.getOne(id);
        return modelMapper.map(passengerType,PassengerTypeDto.class);
    }

    @Override
    public List<PassengerTypeDto> findAllByPassengerType(String passengerType) {
        List<PassengerType> passengerTypeList= (List<PassengerType>) passengerTypeRepository.findAllByPassengerType(passengerType);
        Type listType=new TypeToken<List<PassengerTypeDto>>(){}.getType();
        return modelMapper.map(passengerTypeList,listType);
    }


    @Override
    public PassengerTypeDto save(PassengerTypeDto passengerTypeDto) {
        PassengerType passengertype=modelMapper.map(passengerTypeDto,PassengerType.class);
        passengertype=passengerTypeRepository.save(passengertype);
        return modelMapper.map(passengertype,PassengerTypeDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        PassengerType passengerType=passengerTypeRepository.getOne(id);
        if(passengerType==null){
            throw new IllegalArgumentException("Passenger type does not exist");
        }
        else{
            passengerTypeRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public PassengerTypeDto update(Long id, PassengerTypeDto passengerTypeDto) {
        return null;
    }
}
