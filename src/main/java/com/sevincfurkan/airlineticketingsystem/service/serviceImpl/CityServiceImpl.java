package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.CityDto;
import com.sevincfurkan.airlineticketingsystem.entity.City;
import com.sevincfurkan.airlineticketingsystem.repository.CityRepository;
import com.sevincfurkan.airlineticketingsystem.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository,ModelMapper modelMapper){
        this.cityRepository=cityRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CityDto findById(Long id) {
        City city = cityRepository.getOne(id);
        return modelMapper.map(city,CityDto.class);
    }

    @Override
    public CityDto findByCityName(String cityName) {
        City city=cityRepository.findByCityName(cityName);
        return modelMapper.map(city,CityDto.class);
    }

    @Override
    public CityDto save(CityDto cityDto) {
        City city=modelMapper.map(cityDto,City.class);
        city=cityRepository.save(city);
        return modelMapper.map(city,CityDto.class);
    }

    @Override
    public CityDto update(Long id, CityDto cityDto) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        City city=cityRepository.getOne(id);
        if(city==null){
            return false;
        }else{
            cityRepository.deleteById(id);
            return true;
        }
    }
}
