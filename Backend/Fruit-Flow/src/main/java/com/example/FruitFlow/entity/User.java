package com.example.FruitFlow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String fullName;
    private String password;
    private String address;
    private String email;
}
