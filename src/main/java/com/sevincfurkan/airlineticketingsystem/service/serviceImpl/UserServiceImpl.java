package com.sevincfurkan.airlineticketingsystem.service.serviceImpl;

import com.sevincfurkan.airlineticketingsystem.dto.RegistrationRequest;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.entity.User;
import com.sevincfurkan.airlineticketingsystem.repository.UserRepository;
import com.sevincfurkan.airlineticketingsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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


    @Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = new User();
            user.setMail(registrationRequest.getEmail());
            user.setLastName(registrationRequest.getNameSurname());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUserName(registrationRequest.getUsername());
            userRepository.save(user);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("REGISTRATION=>", e);
            return Boolean.FALSE;
        }
    }
}
