package com.example.FruitFlow.controller;

import com.example.FruitFlow.dto.CustomerDTO;
import com.example.FruitFlow.dto.LoginRequestDTO;
import com.example.FruitFlow.dto.LoginResponseDTO;
import com.example.FruitFlow.dto.TraderDTO;
import com.example.FruitFlow.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("register-customer")
    public ResponseEntity<CustomerDTO>registerAsCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.registerAsCustomer(customerDTO));
    }
    @PostMapping("register-trader")
    public ResponseEntity<TraderDTO>registerAsTrader(@RequestBody TraderDTO traderDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.registerAsTrader(traderDTO));
    }
    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO>login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok().body(authenticationService.login(loginRequestDTO));
    }

}
