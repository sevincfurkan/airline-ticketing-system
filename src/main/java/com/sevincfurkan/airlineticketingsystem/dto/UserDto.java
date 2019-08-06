package com.sevincfurkan.airlineticketingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "USER DATA")
public class UserDto {

    @ApiModelProperty(required = true,value = "ID")
    private Long id;
    @ApiModelProperty(value = "FIRST NAME")
    private String firstName;
    @ApiModelProperty(value = "LAST NAME")
    private String lastName;
    @ApiModelProperty(value = "PHONE")
    private String phone;
    @ApiModelProperty(value = "MAIL")
    private String mail;
    @ApiModelProperty(value = "USER NAME")
    private String userName;
    @ApiModelProperty(value = "PASSWORD")
    private String password;
    private List<RoleDto> roleList;
}
