package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.CountryDto;
import com.sevincfurkan.airlineticketingsystem.entity.Country;
import com.sevincfurkan.airlineticketingsystem.repository.CountryRepository;
import com.sevincfurkan.airlineticketingsystem.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository,ModelMapper modelMapper){
        this.countryRepository=countryRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public CountryDto findById(Long id) {
        Country country=countryRepository.getOne(id);
        return modelMapper.map(country,CountryDto.class);
    }

    @Override
    public CountryDto findByCountryName(String countryName) {
        Country country=countryRepository.findByCountryName(countryName);
        return modelMapper.map(country,CountryDto.class);
    }

    @Override
    public CountryDto save(CountryDto countryDto) {
        Country country=modelMapper.map(countryDto,Country.class);
        country=countryRepository.save(country);
        return modelMapper.map(country,CountryDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        Country country=countryRepository.getOne(id);
        if(country==null){
            return false;
        }else{
            countryRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public CountryDto update(Long id, CountryDto countryDto) {
        return null;
    }
}
