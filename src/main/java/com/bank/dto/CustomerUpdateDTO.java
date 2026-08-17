package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateDTO {

    private int customerId;

    private String name;

    private String aadharNumber;

    private String panNumber;

    private String address;

    private String phoneNumber;

    private String email;
	
}
