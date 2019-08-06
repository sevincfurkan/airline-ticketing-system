package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.AirPortDto;
import com.sevincfurkan.airlineticketingsystem.entity.AirPort;
import com.sevincfurkan.airlineticketingsystem.repository.AirPortRepository;
import com.sevincfurkan.airlineticketingsystem.service.AirPortService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AirPortServiceImpl implements AirPortService {
    private final AirPortRepository airPortRepository;
    private final ModelMapper modelMapper;

    public AirPortServiceImpl(AirPortRepository airPortRepository,ModelMapper modelMapper){
        this.airPortRepository=airPortRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public AirPortDto findById(Long id) {
        AirPort airPort=airPortRepository.getOne(id);
        return modelMapper.map(airPort,AirPortDto.class);
    }

    @Override
    public AirPortDto finByAirPortName(String airPortName) {
        AirPort airPort=airPortRepository.findByAirPortName(airPortName);
        return modelMapper.map(airPort,AirPortDto.class);
    }

    @Override
    public AirPortDto save(AirPortDto airPortDto) {
        AirPort airPort=modelMapper.map(airPortDto,AirPort.class);
        airPort=airPortRepository.save(airPort);
        return modelMapper.map(airPort,AirPortDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        AirPort airPort=airPortRepository.getOne(id);
        if(airPort==null){
            return false;
        }else{
            airPortRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public AirPortDto update(long id, AirPortDto airPortDto) {
        return null;
    }
}
