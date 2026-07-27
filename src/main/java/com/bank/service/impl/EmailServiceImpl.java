package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bank.model.AccountDetails;
import com.bank.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public void mail(AccountDetails accountDetails,String tempPassword) {
		 SimpleMailMessage mail = new SimpleMailMessage();
		  mail.setFrom("manikumar052002@gmail.com");
		  mail.setTo(accountDetails.getCustomer().getEmail());
		  mail.setSubject("Account Created Successfully");
		  mail.setText("Dear Customer,\n\n"+
		  		"Welcome to Smart Bank!\n\n"+
		  		"We are pleased to inform you that your bank account has been successfully created.\n"+
		  		"Your account details are:\n"+
		  		"Account Number: "+ accountDetails.getAccountNumber()+"\n"+
		  		"Temporary Password: "+ "\n"+ tempPassword+ "\n"+
		  		"Please use these credentials to log in to your account.\n\n"+
		  		"For security purposes, you are required to change your temporary password after your first login.\n\n"+
		  		"If you did not request this account, please contact our support team immediately.\n\n"+
		  		"Thank you for choosing Smart Bank.\n\n"+
		  		"Regards,\n\n"+
		  		"Smart Bank\n\n"+
		  		"Customer Support");
	      mail.setCc("mmanikumar8360@gmail.com");
		  javaMailSender.send(mail);
	}

}
