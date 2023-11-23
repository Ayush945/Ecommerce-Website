package com.example.FruitFlow.dto;

import com.example.FruitFlow.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
/**
 * DTO to transfer data.
 * For Login Request
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRequestDTO {
    @NotBlank(message = "Field cannot be blank")
    private String username;
    private String password;
    private RoleEnum role;

}
