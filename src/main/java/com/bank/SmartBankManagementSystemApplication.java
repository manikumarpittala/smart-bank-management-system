package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.bank.model.Gender;
import com.bank.model.OTP;

@EnableScheduling
@SpringBootApplication
public class SmartBankManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartBankManagementSystemApplication.class, args); 
         

		 OTP otp = new OTP();
	     Gender gender = Gender.FEMALE;
		
		
//       203090854727
//		 424431123867
	}
}
