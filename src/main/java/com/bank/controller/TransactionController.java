package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.dto.TransferDetailsRequest;
import com.bank.model.AccountDetails;
import com.bank.model.TransactionDetails;
import com.bank.service.impl.TransactionServiceImpl;

@Controller
@RequestMapping("/customer")
public class TransactionController {

	@Autowired
	TransactionServiceImpl transactionService;
	
	@PostMapping("/validateBenificiary")
	public String validateBenificary(@RequestParam long receiverAccountNumber,@RequestParam long reEnteredAccountNumber,Model model) {
		AccountDetails validateBenificary = transactionService.validateBenificary(receiverAccountNumber,reEnteredAccountNumber);
		if(transactionService.validateBenificary(receiverAccountNumber,reEnteredAccountNumber)!=null) {
         model.addAttribute("valid", validateBenificary);
         
         return "transfer-reverify";
	} 
		model.addAttribute("incorrect", "Receiver AccountNumber & ReEnteredAccountNumber");
		return "transfer-reverify";
	}
	
	@GetMapping("/transactions")
	public String getTransactionsByPage(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size,Model model){
		Page<TransactionDetails> transactionsByPage = transactionService.getTransactionsByPage(page, size);
		 model.addAttribute("transactions", transactionsByPage);
		return "transactions";
	}
	
	
	@PostMapping("/transferMoney")
	public String transferMoney(@ModelAttribute TransferDetailsRequest transDetails) {
		if(transactionService.transferMoney(transDetails)!=null) {
		transactionService.transferMoney(transDetails);
	    return "transfer-successful";
		}
		return "transfer-reverify";
	}
	
}
