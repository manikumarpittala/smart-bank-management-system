package com.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.builders.CustomerBuilders;
import com.bank.dao.AccountDetailsRepository;
import com.bank.dao.AdminRepository;
import com.bank.dao.CustomerDetailsRepository;
import com.bank.dto.AdminLoginDTO;
import com.bank.dto.CreateAccountRequestDTO;
import com.bank.dto.CreateAccountResponseDTO;
import com.bank.dto.CustomerUpdateDTO;
import com.bank.model.AccountDetails;
import com.bank.model.Admin;
import com.bank.model.CustomerDetails;
import com.bank.service.AdminService;
import com.bank.service.EmailService;

import jakarta.servlet.http.HttpSession;
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
	
	@Autowired
	AdminRepository adminRepo;

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

	@Override
	public Admin login(AdminLoginDTO adminLogin) {
         Admin adminByEmail = adminRepo.findByEmail(adminLogin.getEmail());
         if(adminByEmail!=null && adminByEmail.getRole().equals("admin") && passEncoder.matches(adminLogin.getPassword(), adminByEmail.getPassword())) {
        	 return adminByEmail;
         }else {
         return null;
	}
	}

	@Override
	public boolean secretKey(String secretkey,HttpSession session) {
         Admin admin = (Admin) session.getAttribute("admin");
         if(passEncoder.matches(secretkey, admin.getSecretKey())) {
        	 return true;
         }else {
        	 return false;
         }
	}

	@Override
	public List<CustomerDetails> viewAllCustomers() {
       return customerDetailsRepo.findAll();
	}

	@Override
	public List<AccountDetails> viewAllAccounts() {
		return accountDetailsRepo.findAll();
	}

	@Override
	public CustomerDetails findCustomer(int id) {
      return customerDetailsRepo.findById(id).get();
	}

	@Override
	public void updateCustomer(CustomerUpdateDTO customer) {
      CustomerDetails customerDetails = customerDetailsRepo.findById(customer.getCustomerId()).get();
      customerDetails.setAadharNumber(customer.getAadharNumber());
      customerDetails.setAddress(customer.getAddress());
      customerDetails.setEmail(customer.getEmail());
      customerDetails.setName(customer.getName());
      customerDetails.setPanNumber(customer.getPanNumber());
      customerDetails.setPhoneNumber(customer.getPhoneNumber());
      customerDetailsRepo.save(customerDetails);
	}

	@Override
	public void deactivateAccount(int id) {
      AccountDetails accountDetails = accountDetailsRepo.findById(id).get();
      accountDetails.setActive(false);
      accountDetailsRepo.save(accountDetails);
	}
	
	@Override
	public void activateAccount(int id) {
      AccountDetails accountDetails = accountDetailsRepo.findById(id).get();
      accountDetails.setActive(true);
      accountDetailsRepo.save(accountDetails);
	}
	
	
}
