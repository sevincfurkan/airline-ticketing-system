package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "passenger  type data")
public class PassengerTypeDto {
    @ApiModelProperty(value = "passenger type id")
    private Long id;
    @ApiModelProperty(value = "passenger type")
    private String passengerType;
    @ApiModelProperty(value = "passenger list")
    private List<PassengerDto> passengerList;

}
