package com.sevincfurkan.airlineticketingsystem.dto;

        import io.swagger.annotations.ApiModel;
        import io.swagger.annotations.ApiModelProperty;
        import lombok.Data;

        import java.util.List;
@Data
@ApiModel(value = "airport data")
public class AirPortDto {
    @ApiModelProperty(value = "airport id")
    private Long id;
    @ApiModelProperty(value = "airport name")
    private String airPortName;
    @ApiModelProperty(value = "city name")
    private CityDto cityName;
    @ApiModelProperty(value = "airplane list")
    private List<AirPlaneDto> airPlaneList;
    @ApiModelProperty(value = "rota list")
    private List<RotaDto> rotaList;
}
