package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.RotaDto;
import com.sevincfurkan.airlineticketingsystem.entity.AirPort;
import com.sevincfurkan.airlineticketingsystem.entity.Rota;
import com.sevincfurkan.airlineticketingsystem.repository.RotaRepository;
import com.sevincfurkan.airlineticketingsystem.service.RotaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.List;
@Service
public class RotaServiceImpl implements RotaService {
    private final RotaRepository rotaRepository;
    private final ModelMapper modelMapper;

    public RotaServiceImpl(RotaRepository rotaRepository,ModelMapper modelMapper){
        this.rotaRepository=rotaRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public RotaDto findById(Long id) {
        Rota rota=rotaRepository.getOne(id);
        return modelMapper.map(rota,RotaDto.class);
    }

    @Override
    public List<RotaDto> findAllByTakeOff(Date takeOff) {
        List<Rota> rotaList=rotaRepository.findAllByTakeOff(takeOff);
        Type listType=new TypeToken<List<RotaDto>>(){}.getType();
        return modelMapper.map(rotaList,listType);
    }

    @Override
    public List<RotaDto> findAllByArrival(Date arrival) {
        List<Rota> rotaList=rotaRepository.findAllByArrival(arrival);
        Type listType=new TypeToken<List<RotaDto>>(){}.getType();
        return modelMapper.map(rotaList,listType);
    }



    @Override
    public RotaDto save(RotaDto rotaDto) {
        Rota rota = modelMapper.map(rotaDto,Rota.class);
        rota=rotaRepository.save(rota);
        return modelMapper.map(rota,RotaDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        Rota rota=rotaRepository.getOne(id);
        if(rota==null){
            throw new IllegalArgumentException("Rota does not already exist");
        }
        else{
            rotaRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public RotaDto update(Long id, RotaDto rotaDto) {
        return null;
    }
}
