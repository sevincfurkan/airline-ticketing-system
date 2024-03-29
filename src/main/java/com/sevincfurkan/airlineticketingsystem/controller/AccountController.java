package com.sevincfurkan.airlineticketingsystem.controller;

import com.sevincfurkan.airlineticketingsystem.dto.LoginRequest;
import com.sevincfurkan.airlineticketingsystem.dto.RegistrationRequest;
import com.sevincfurkan.airlineticketingsystem.dto.TokenResponse;
import com.sevincfurkan.airlineticketingsystem.dto.UserDto;
import com.sevincfurkan.airlineticketingsystem.entity.User;
import com.sevincfurkan.airlineticketingsystem.repository.UserRepository;
import com.sevincfurkan.airlineticketingsystem.security.JwtTokenUtil;
import com.sevincfurkan.airlineticketingsystem.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final User user = userRepository.findByUserName(request.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(user.getUserName(), token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationRequest registrationRequest) throws AuthenticationException {
        Boolean response = userService.register(registrationRequest);
        return ResponseEntity.ok(response);
    }

   /* @PostMapping
    @ResponseBody
    public ResponseEntity<TokenResponse> getToken(@RequestBody LoginRequest request) throws AuthenticationServiceException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User theUser = userService.findByUserName(request.getUsername());
        String token = jwtTokenUtil.generateToken(theUser);
        return ResponseEntity.ok(new TokenResponse(theUser.getUserName(), token));
    }*/

}
