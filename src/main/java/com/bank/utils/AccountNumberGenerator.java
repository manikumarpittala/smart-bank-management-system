package com.bank.utils;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.dao.AccountDetailsRepository;

@Component
public class AccountNumberGenerator {

	@Autowired
	AccountDetailsRepository accRepo;
	
	public long generateAccountNumber() {
		Random random = new Random();
		long accNum = random.nextLong(100000000000L, 999999999999L);
        while(accRepo.findByAccountNumber(accNum) != null) {
        	accNum = random.nextLong(100000000000L, 999999999999L);
        }
        return accNum;
        }
	
	}
	
    
