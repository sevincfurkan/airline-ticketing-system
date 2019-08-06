package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "passenger data")
public class PassengerDto {
    @ApiModelProperty(value = "passenger id")
    private Long id;
    @ApiModelProperty(value = "passenger first name")
    private String firstName;
    @ApiModelProperty(value = "passenger last name")
    private String lastName;
    @ApiModelProperty(value = "passenger birth date")
    private Date birthDate;
    @ApiModelProperty(value = "passenger tc no")
    private String TCNo;
    @ApiModelProperty(value = "passenger p type")
    private PassengerTypeDto passengerTypeName;
}
