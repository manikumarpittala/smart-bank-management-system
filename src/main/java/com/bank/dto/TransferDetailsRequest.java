package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDetailsRequest {

	private long senderAccountNumber;
	
	private long benificaryAccountNumber;
	
	private int transferAmount;
	
	private String transferType;
	
}
