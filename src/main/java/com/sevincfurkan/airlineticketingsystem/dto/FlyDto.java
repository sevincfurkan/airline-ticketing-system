package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "fly data")
public class FlyDto {
    @ApiModelProperty(value = "fly id")
    private Long id;
    @ApiModelProperty(value = "fly rota name")
    private RotaDto rotaName;
}
