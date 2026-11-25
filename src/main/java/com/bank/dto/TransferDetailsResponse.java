package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDetailsResponse {

	private long senderAccoutNumber;
	
	private String benificaryName;
	
	private long benificaryAccoutNumber;
	
	private int transferAmount;
	
}
