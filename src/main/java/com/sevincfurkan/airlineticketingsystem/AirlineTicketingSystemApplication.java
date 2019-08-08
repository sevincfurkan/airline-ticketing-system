package com.sevincfurkan.airlineticketingsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AirlineTicketingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineTicketingSystemApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

}
