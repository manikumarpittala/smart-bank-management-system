package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferMoneyRequestDTO {
    
	private long toAccountNumber;
	
	private double amount;
	
	private String password;
	
}
