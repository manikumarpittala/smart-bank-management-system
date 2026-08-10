package com.bank.service;

import com.bank.model.AccountDetails;

public interface ValidationService {

	public AccountDetails login(long accountNumber, String password);
	
	public String verifyOTP(int value,long accountNumber);
	
	public String changePassword(long accountNumber,String oldPassword,String newPassword,String confirmPassword );
	
	public void resendOtp(long accountNumber);
	
}
