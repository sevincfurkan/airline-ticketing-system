package com.sevincfurkan.airlineticketingsystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "role data")
public class RoleDto {
    @ApiModelProperty(value = "role id")
    private Long id;
    @ApiModelProperty(value = "role name")
    private String roleName;
}
