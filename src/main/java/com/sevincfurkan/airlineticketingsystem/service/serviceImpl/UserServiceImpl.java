package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.entity.User;
import com.sevincfurkan.airlineticketingsystem.repository.UserRepository;
import com.sevincfurkan.airlineticketingsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserDto save(UserDto userDto) {

        User user = modelMapper.map(userDto,User.class);
        user = userRepository.save(user);
        return modelMapper.map(user,UserDto.class);

    }

    @Override
    public Boolean delete(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public UserDto findById(Long id) {
        User user=userRepository.getOne(id);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> findAllByFirstName(String firstName) {
        List<User> userList = userRepository.findAllByFirstName(firstName);
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        return modelMapper.map(userList,listType);
    }

    @Override
    public List<UserDto> findAllByLastName(String lastName) {
        List<User> userList=userRepository.findAllByLastName(lastName);
        Type lisType=new TypeToken<List<UserDto>>(){}.getType();
        return modelMapper.map(userList,lisType);
    }

    @Override
    public UserDto findByUserName(String userName) {
        User user=userRepository.findByUserName(userName);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto findByMail(String mail) {
        User user=userRepository.findByMail(mail);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto update(Long id,UserDto userDto) {
        UserDto userId=findById(id);
        if(userId!=null){
            throw new IllegalArgumentException("Id already exist:"+id);
        }
        userId.setFirstName(userDto.getFirstName());
        return save(userId);
    }
}
