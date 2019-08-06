package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.RoleDto;
import com.sevincfurkan.airlineticketingsystem.entity.Role;
import com.sevincfurkan.airlineticketingsystem.repository.RoleRepository;
import com.sevincfurkan.airlineticketingsystem.service.RoleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository,ModelMapper modelMapper){
        this.roleRepository=roleRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public RoleDto findById(Long id) {
        Role role=roleRepository.getOne(id);
        return modelMapper.map(role,RoleDto.class);
    }

    @Override
    public List<RoleDto> findAllByRoleName(String roleDto) {
        List<Role> roleList=roleRepository.findAllByRoleName(roleDto);
        Type typeList=new TypeToken<List<RoleDto>>(){}.getType();
        return modelMapper.map(roleList,typeList);
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role=modelMapper.map(roleDto,Role.class);
        role=roleRepository.save(role);
        return modelMapper.map(role,RoleDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        Role role=roleRepository.getOne(id);

        if(role==null){
            throw new IllegalArgumentException("Role does not exist");
        }
        else{
            roleRepository.deleteById(id);
            return true;
        }

    }

    @Override
    public RoleDto update(Long id, RoleDto roleDto) {
        return null;
    }
}
