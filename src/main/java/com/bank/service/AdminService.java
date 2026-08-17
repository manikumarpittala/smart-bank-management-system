package com.bank.service;

import java.util.List;

import com.bank.dto.AdminLoginDTO;
import com.bank.dto.CreateAccountRequestDTO;
import com.bank.dto.CreateAccountResponseDTO;
import com.bank.dto.CustomerUpdateDTO;
import com.bank.model.AccountDetails;
import com.bank.model.Admin;
import com.bank.model.CustomerDetails;

import jakarta.servlet.http.HttpSession;

public interface AdminService {

	public CreateAccountResponseDTO createAccount(CreateAccountRequestDTO createAccountDTO);
	
	public Admin login(AdminLoginDTO adminLogin);
	
	public boolean secretKey(String secretkey,HttpSession session); 

    public List<CustomerDetails> viewAllCustomers();
	
	public List<AccountDetails> viewAllAccounts();
	
	public CustomerDetails findCustomer(int id);
	
	public void updateCustomer(CustomerUpdateDTO customer);
	
	public void deactivateAccount(int id);
	
	public void activateAccount(int id);	
}
