package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.CreateAccountRequestDTO;
import com.bank.dto.CreateAccountResponseDTO;
import com.bank.service.impl.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@PostMapping("/createAccount")
	public CreateAccountResponseDTO createAccount(@RequestBody CreateAccountRequestDTO createAccountDTO) {
		return adminService.createAccount(createAccountDTO);
		}
		
}
