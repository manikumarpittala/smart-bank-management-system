package com.bank.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator {

	public String generatePassword() {
		Random random = new Random();
		String temp = "Temp@"+random.nextInt(10000, 99999);
		return temp;
	}
	
}
