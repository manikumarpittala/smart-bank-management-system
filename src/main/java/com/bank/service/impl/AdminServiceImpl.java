package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.builders.CustomerBuilders;
import com.bank.dao.AccountDetailsRepository;
import com.bank.dao.CustomerDetailsRepository;
import com.bank.dto.CreateAccountRequestDTO;
import com.bank.dto.CreateAccountResponseDTO;
import com.bank.model.AccountDetails;
import com.bank.model.CustomerDetails;
import com.bank.service.AdminService;
import com.bank.service.EmailService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	CustomerDetailsRepository customerDetailsRepo;
	
	@Autowired
	AccountDetailsRepository accountDetailsRepo;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	CustomerBuilders customerBuilder;
	
	@Autowired
	PasswordEncoder passEncoder;

	@Override
	public CreateAccountResponseDTO createAccount(CreateAccountRequestDTO createAccountDTO) {
		CustomerDetails customerDetails = CustomerBuilders.buildCustomerDetails(createAccountDTO);
		CustomerDetails savedCustomer = customerDetailsRepo.save(customerDetails);
		AccountDetails accountDetails = customerBuilder.buildAccountDetails();
		  accountDetails.setCustomer(savedCustomer);
		  String password = accountDetails.getPassword();
	   	  String encodedPassword = passEncoder.encode(password);
		  accountDetails.setPassword(encodedPassword);
		  AccountDetails savedAccountDetails = accountDetailsRepo.save(accountDetails);
		 emailService.mail(savedAccountDetails,password);
		return CustomerBuilders.buildAccountResponse(savedAccountDetails);
	}

}
