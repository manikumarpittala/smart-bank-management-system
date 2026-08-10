package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmartBankManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartBankManagementSystemApplication.class, args); 
         
	}
}
