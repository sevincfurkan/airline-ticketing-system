package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "country data")
public class CountryDto {
    @ApiModelProperty(value = "country id")
    private Long id;
    @ApiModelProperty(value = "country name")
    private String countryName;
    @ApiModelProperty(value = "country city")
    private List<CityDto> cityList;
}
