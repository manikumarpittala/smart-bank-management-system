package com.bank.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.dto.CreateAccountRequestDTO;
import com.bank.dto.CreateAccountResponseDTO;
import com.bank.model.AccountDetails;
import com.bank.model.CustomerDetails;
import com.bank.utils.AccountNumberGenerator;
import com.bank.utils.PasswordGenerator;

@Component
public class CustomerBuilders {
	
	@Autowired
	AccountNumberGenerator accNumGenerator;
	
	@Autowired
	PasswordGenerator passwordGenerator;


	public static CustomerDetails buildCustomerDetails(CreateAccountRequestDTO createAccountRequestDTO) {
		return CustomerDetails.builder()
				.name(createAccountRequestDTO.getName())
				.aadharNumber(createAccountRequestDTO.getAadharNumber())
				.panNumber(createAccountRequestDTO.getPanNumber())
				.address(createAccountRequestDTO.getAddress())
				.phoneNumber(createAccountRequestDTO.getPhoneNumber())
				.email(createAccountRequestDTO.getEmail())
				.build();		
	}
	
    public AccountDetails buildAccountDetails() {
		return AccountDetails.builder()
						.accountNumber(accNumGenerator.generateAccountNumber())
						.balance(0)
						.isFirst(true)
						.isActive(true)
						.password(passwordGenerator.generatePassword())
						.build();
			
    }
    
    public static CreateAccountResponseDTO buildAccountResponse(AccountDetails accountDetails) {
    	return CreateAccountResponseDTO.builder()
    			.accountNumber(accountDetails.getAccountNumber())
    			.message("Account created successfully. Temporary password has been sent to the registered email.")
    			.email(accountDetails.getCustomer().getEmail())
    			.customerName(accountDetails.getCustomer().getName())
    			.build();

    }
}
