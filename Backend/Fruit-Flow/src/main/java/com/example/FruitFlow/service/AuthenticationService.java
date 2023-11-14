package com.example.FruitFlow.service;

import com.example.FruitFlow.dto.CustomerDTO;
import com.example.FruitFlow.dto.LoginRequestDTO;
import com.example.FruitFlow.dto.LoginResponseDTO;
import com.example.FruitFlow.dto.TraderDTO;
import com.example.FruitFlow.enums.RoleEnum;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthenticationService {
    UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String username, RoleEnum role);

    CustomerDTO registerAsCustomer(CustomerDTO customerDTO);

    TraderDTO registerAsTrader(TraderDTO traderDTO);

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    void createAdmin();
}
