package com.bank.service;

import com.bank.model.AccountDetails;

public interface OTPService {

	public void generatorOtpThroughEmail(AccountDetails account);
	
	public void updatingOtpValidation();
}
