package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "rota data")
public class RotaDto {
    @ApiModelProperty(value = "rota id")
    private Long id;
    @ApiModelProperty(value = "take off")
    private Date takeOff;
    @ApiModelProperty(value = "arrival")
    private Date arrival;
    @ApiModelProperty(value = "airport name")
    private AirPortDto airPortName;
    @ApiModelProperty(value = "rota fly list")
    private List<FlyDto> flyList;
    private String dLat;
    private String dLong;
}
