package com.example.FruitFlow.service.impl;

import com.example.FruitFlow.enums.RoleEnum;
import com.example.FruitFlow.service.AuthenticationService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String username, RoleEnum role) {
        if(role.equals(RoleEnum.ROLE_CUSTOMER)){
            //Customer
        } else if (role.equals(RoleEnum.ROLE_TRADER)) {
            //Trader
        }
        else {
            //Admin
        }
        return null;
    }
}
