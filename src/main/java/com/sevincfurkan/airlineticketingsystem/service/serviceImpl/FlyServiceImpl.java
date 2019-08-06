package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.FlyDto;
import com.sevincfurkan.airlineticketingsystem.entity.Fly;
import com.sevincfurkan.airlineticketingsystem.repository.FlyRepository;
import com.sevincfurkan.airlineticketingsystem.service.FlyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class FlyServiceImpl implements FlyService {
    private final FlyRepository flyRepository;
    private final ModelMapper modelMapper;

    public FlyServiceImpl(FlyRepository flyRepository,ModelMapper modelMapper){
        this.flyRepository=flyRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public FlyDto findById(Long id) {
        Fly fly=flyRepository.getOne(id);
        return modelMapper.map(fly,FlyDto.class);
    }

    @Override
    public List<FlyDto> findAllByRotaName(String rotaDto) {
        List<Fly> flyList= (List<Fly>) flyRepository.findAllByRotaName(rotaDto);
        Type listType=new TypeToken<List<FlyDto>>(){}.getType();
        return modelMapper.map(flyList,listType);

    }

    @Override
    public FlyDto save(FlyDto flyDto) {
        Fly fly=modelMapper.map(flyDto,Fly.class);
        fly=flyRepository.save(fly);
        return modelMapper.map(fly,FlyDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        Fly fly=flyRepository.getOne(id);
        if(fly==null){
            return false;
        }else{
            flyRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public FlyDto update(Long id, FlyDto flyDto) {
        return null;
    }
}
