package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.AccountDetails;

@Service
public interface EmailService {

	public void mail(AccountDetails accountDetails,String tempPassword);

}
