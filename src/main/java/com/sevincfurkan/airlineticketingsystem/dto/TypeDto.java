package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "type data")
public class TypeDto {
    @ApiModelProperty(value = "type id",required = true)
    private Long id;
    @ApiModelProperty(value = "type data")
    private String type;
    @ApiModelProperty(value = "type ticket")
    private List<TicketDto> ticketList;
}
