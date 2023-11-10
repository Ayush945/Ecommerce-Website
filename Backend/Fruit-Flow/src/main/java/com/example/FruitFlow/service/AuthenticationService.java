package com.example.FruitFlow.service;

import com.example.FruitFlow.enums.RoleEnum;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthenticationService {
    UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String username, RoleEnum role);
}
