package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "city data")
public class CityDto {
    @ApiModelProperty(value = "city id")
    private Long id;
    @ApiModelProperty(value = "city name")
    private String cityName;
    @ApiModelProperty(value = "city county name")
    private CountryDto countryName;
    @ApiModelProperty(value = "city airport list")
    private List<AirPortDto> airPortList;
}
