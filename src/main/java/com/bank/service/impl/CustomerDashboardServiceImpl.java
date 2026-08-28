package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDetailsRepository;
import com.bank.model.AccountDetails;
import com.bank.service.CustomerDashboardService;

@Service
public class CustomerDashboardServiceImpl implements CustomerDashboardService{

	@Autowired
	AccountDetailsRepository accountRepo;
	
	@Override
	public AccountDetails accountDetails(long accountNumber) {
      AccountDetails accountDetails = accountRepo.findByAccountNumber(accountNumber);
		return accountDetails;
	}

}
