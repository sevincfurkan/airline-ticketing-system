package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ticket data")
public class TicketDto {
    @ApiModelProperty(value = "ticket id")
    private Long id;
    @ApiModelProperty(value = "ticket airplane name")
    private AirPlaneDto airPlaneName;
    @ApiModelProperty(value = "type name")
    private TypeDto typeName;
}
