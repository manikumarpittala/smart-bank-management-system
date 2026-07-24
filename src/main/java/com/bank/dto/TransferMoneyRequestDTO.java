package com.bank.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferMoneyRequestDTO {
    
	private long toAccountNumber;
	
	@Min(value = 1, message = "Transfer amount must be greater than zero")
	private double amount;
	
	private String password;
	
}
