package com.sevincfurkan.airlineticketingsystem.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String username;
    private String password;
    private String email;
}
