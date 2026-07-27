package com.bank.service;

import com.bank.dto.CreateAccountRequestDTO;
import com.bank.dto.CreateAccountResponseDTO;

public interface AdminService {

	public CreateAccountResponseDTO createAccount(CreateAccountRequestDTO createAccountDTO);
	
}
