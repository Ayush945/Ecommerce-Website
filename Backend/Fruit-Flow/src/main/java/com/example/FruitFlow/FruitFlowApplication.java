package com.example.FruitFlow;

import com.example.FruitFlow.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FruitFlowApplication implements CommandLineRunner {
	@Autowired
	private AuthenticationService authenticationService;
	public static void main(String[] args) {
		SpringApplication.run(FruitFlowApplication.class, args);

	}
	@Override
	public void run(String ...args) throws Exception{
		authenticationService.createAdmin();
	}
}
