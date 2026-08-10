package com.bank.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bank.dao.OTPRepository;
import com.bank.model.AccountDetails;
import com.bank.model.OTP;
import com.bank.service.OTPService;
import com.bank.utils.OTPGenerator;

@Service
public class OTPServiceImpl implements OTPService{

	@Autowired
	OTPGenerator otpGenerator;
	
	@Autowired
	EmailServiceImpl emailService;
	
	@Autowired
	OTPRepository otpRepo;
	
	
	@Override
	public void generatorOtpThroughEmail(AccountDetails account) {
		int otp = otpGenerator.generateOtp();
		LocalDateTime localDateTime = LocalDateTime.now();
		emailService.otpMail(otp, account.getCustomer().getEmail());
		OTP oneTimePassword = new OTP();
		oneTimePassword.setAccount(account);
		oneTimePassword.setEmail(account.getCustomer().getEmail());
		oneTimePassword.setIssuedTime(LocalDateTime.now());
		oneTimePassword.setOtpValue(otp);
		oneTimePassword.setExpirationTime(localDateTime.plusMinutes(5));
		
		if(oneTimePassword.getExpirationTime().isBefore(oneTimePassword.getIssuedTime().plusMinutes(5))) {
			oneTimePassword.setValid(true);
		}else {
			oneTimePassword.setValid(false);
		}
		otpRepo.save(oneTimePassword);
	}


	@Scheduled(cron ="0 * * * * *")
	@Override
	public void updatingOtpValidation() {
		List<OTP> all = otpRepo.findAll();
		for(OTP otp: all) {
		     if (LocalDateTime.now().isAfter(otp.getExpirationTime()) && otp.isValid()) {
		            otp.setValid(false);
		            otpRepo.save(otp);
		        }
		}
	}

}
