package com.sevincfurkan.airlineticketingsystem.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "airplane data")
public class AirPlaneDto {
    @ApiModelProperty(value = "airport id")
    private Long id;
    @ApiModelProperty(value = "airport name")
    private String airPlaneName;
    @ApiModelProperty(value = "airplane model")
    private String airPlaneModel;
    @ApiModelProperty(value = "airport name")
    private AirPortDto airPortName;
    @ApiModelProperty(value = "capacity")
    private int capacity;
    @ApiModelProperty(value = "ticket list")
    private List<TicketDto> ticketList;
}
