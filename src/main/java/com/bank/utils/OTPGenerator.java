package com.bank.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OTPGenerator {

	public int generateOtp() {
		Random random = new Random();
		return random.nextInt(1000, 10000);
	}
	
}
