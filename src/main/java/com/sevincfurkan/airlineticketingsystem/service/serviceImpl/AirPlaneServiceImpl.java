package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.AirPlaneDto;
import com.sevincfurkan.airlineticketingsystem.entity.AirPlane;
import com.sevincfurkan.airlineticketingsystem.repository.AirPlaneRepository;
import com.sevincfurkan.airlineticketingsystem.service.AirPlaneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AirPlaneServiceImpl implements AirPlaneService {
    private final AirPlaneRepository airPlaneRepository;
    private final ModelMapper modelMapper;

    public AirPlaneServiceImpl(AirPlaneRepository airPlaneRepository,ModelMapper modelMapper){
        this.airPlaneRepository=airPlaneRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public AirPlaneDto findById(Long id) {
        AirPlane airPlane=airPlaneRepository.getOne(id);
        return modelMapper.map(airPlane,AirPlaneDto.class);
    }

    @Override
    public AirPlaneDto findByAirPlaneName(String airPlaneName) {
        AirPlane airPlane=airPlaneRepository.findByAirPlaneName(airPlaneName);
        return modelMapper.map(airPlane,AirPlaneDto.class);
    }

    @Override
    public AirPlaneDto save(AirPlaneDto airPlaneDto) {
        AirPlane airPlane=modelMapper.map(airPlaneDto,AirPlane.class);
        airPlane=airPlaneRepository.save(airPlane);
        return modelMapper.map(airPlane,AirPlaneDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        AirPlane airPlane=airPlaneRepository.getOne(id);
        if(airPlane==null){
            throw new IllegalArgumentException("Airplane already delete");
        }
        else{
            airPlaneRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public AirPlaneDto update(Long id, AirPlaneDto airPlaneDto) {
        return null;
    }
}
