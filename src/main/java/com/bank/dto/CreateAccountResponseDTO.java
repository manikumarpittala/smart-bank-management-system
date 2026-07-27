package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountResponseDTO {

    private String customerName;
	
    private long accountNumber;
    
    private String password;
    
    private String email;

}
