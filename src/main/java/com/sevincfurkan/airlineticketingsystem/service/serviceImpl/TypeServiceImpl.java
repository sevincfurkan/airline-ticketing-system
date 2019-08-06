package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.TypeDto;
import com.sevincfurkan.airlineticketingsystem.entity.Type;
import com.sevincfurkan.airlineticketingsystem.repository.TypeRepository;
import com.sevincfurkan.airlineticketingsystem.service.TypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final ModelMapper modelMapper;

    public TypeServiceImpl(TypeRepository typeRepository, ModelMapper modelMapper) {
        this.typeRepository = typeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TypeDto save(TypeDto typeDto) {
        Type type = modelMapper.map(typeDto, Type.class);
        type = typeRepository.save(type);
        return modelMapper.map(type, TypeDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        try {
            typeRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public TypeDto findById(Long id) {
        Type type = typeRepository.getOne(id);
        return modelMapper.map(type, TypeDto.class);
    }

    @Override
    public List<TypeDto> findAllByTypeName(String type) {
        List<Type> typeList=typeRepository.findAllByType(type);
        java.lang.reflect.Type listType=new TypeToken<List<TypeDto>>(){}.getType();
        return modelMapper.map(typeList,listType);
    }

    @Override
    public TypeDto update(Long id, TypeDto typeDto) {
        TypeDto typeDtoId=findById(id);
        if(typeDtoId!=null){
            throw  new IllegalArgumentException("Id already exist:"+id);
        }
        typeDtoId.setType(typeDto.getType());
        return save(typeDtoId);
    }
}
