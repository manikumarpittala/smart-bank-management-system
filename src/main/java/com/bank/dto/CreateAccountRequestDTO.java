package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequestDTO {

	private String name;
	
	private String aadharNumber;
	
	private String panNumber;
	
	private String address;
	
	private String phoneNumber;
	
	private String email;
	
	private double openingBalance;
}
