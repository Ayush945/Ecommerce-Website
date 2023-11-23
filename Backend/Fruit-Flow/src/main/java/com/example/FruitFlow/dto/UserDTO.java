package com.example.FruitFlow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
/**
 * DTO to transfer data.
 * For User
 * */
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String username;
    private String fullName;
    private String password;
    private String address;
    private String email;
}
