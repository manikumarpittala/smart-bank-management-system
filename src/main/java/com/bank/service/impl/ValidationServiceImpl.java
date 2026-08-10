package com.bank.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDetailsRepository;
import com.bank.dao.OTPRepository;
import com.bank.model.AccountDetails;
import com.bank.model.OTP;
import com.bank.service.ValidationService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ValidationServiceImpl implements ValidationService{
	
	@Autowired
	AccountDetailsRepository accountDetRepo;
	
	@Autowired
	OTPServiceImpl otpService;
	
	@Autowired
	OTPRepository otpRepo;
	
	@Autowired
	PasswordEncoder passEnco;

	@Override
	public AccountDetails login(long accountNumber, String password) {

	    AccountDetails account =
	            accountDetRepo.findByAccountNumber(accountNumber);	    
	    
	    if (account != null &&
	    	passEnco.matches(password, account.getPassword()) && account.isActive()) {
            otpService.generatorOtpThroughEmail(account);
	        return account;
	    }

	    return null;
	}

	@Override
	public String verifyOTP(int value,long accountNumber) {
		AccountDetails byAccountNumber = accountDetRepo.findByAccountNumber(accountNumber);
		List<OTP> otpList = otpRepo.findAllByAccountAccountId(byAccountNumber.getAccountId());
		  for(OTP otp : otpList) {
			  if (otp.getOtpValue() == value
		                && LocalDateTime.now().isBefore(otp.getExpirationTime())) {
		          if(byAccountNumber.isFirst()) {
		        	  return "resetpassword";
		          }else {
		        	  return "directlogin";
		          }
			  }
		  }
		  return "invalid";
	}

	@Override
	public String changePassword(long accountNumber, String oldPassword, String newPassword, String confirmPassword) {
		AccountDetails byAccountNumber = accountDetRepo.findByAccountNumber(accountNumber);
		if(byAccountNumber.getPassword().equals(oldPassword) && newPassword.equals(confirmPassword)) {
			@Nullable
			String encodedPassword = passEnco.encode(newPassword);
			byAccountNumber.setPassword(encodedPassword);
			byAccountNumber.setFirst(false);
			accountDetRepo.save(byAccountNumber);
			return "done";
		}else {
			return "notdone";
		}
		}
	
	@Override
	public void resendOtp(long accountNumber) {
		AccountDetails accountDetails = accountDetRepo.findByAccountNumber(accountNumber);
		otpService.generatorOtpThroughEmail(accountDetails);
	}


}