package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferMoneyRequestDTO {
    
	private long toAccountNumber;
	
	private double amount;
	
	private String password;
	
}
