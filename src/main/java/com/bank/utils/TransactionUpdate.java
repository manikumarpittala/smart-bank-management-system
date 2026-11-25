package com.bank.utils;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDetailsRepository;
import com.bank.dao.TransactionDetailsRepository;
import com.bank.model.AccountDetails;
import com.bank.model.TransactionDetails;

@Transactional
@Component
public class TransactionUpdate {
     
	@Autowired
	TransactionDetailsRepository transactionRepo;
	
	@Autowired
	AccountDetailsRepository account;
	
	public void creditUpdate(long accountNumber,int amount) {
		AccountDetails accountNum = account.findByAccountNumber(accountNumber);
		System.out.println("Update Kosammmmmmmmmmmmmmmmmmmm");
      TransactionDetails transDet = new TransactionDetails();
      transDet.setAccount(accountNum);
      transDet.setCredit(amount);
      transDet.setDebit(0);
      transDet.setTransactionAmount(amount);
      transDet.setTransactionType("Credited Regarding Payment");
	  transDet.setTransactionDate(LocalDate.now());
	  transactionRepo.save(transDet);
	}
 	
	public void debitUpdate(long accountNumber,int amount,String remarks) {
		AccountDetails accountNum = account.findByAccountNumber(accountNumber);
		System.out.println("Debittttttttttttttttttttttttttttttttttttttt");
	      TransactionDetails transDet = new TransactionDetails();
	      transDet.setAccount(accountNum);
	      transDet.setCredit(0);
	      transDet.setDebit(amount);
	      transDet.setTransactionAmount(amount);
	      transDet.setTransactionType(remarks);
		  transDet.setTransactionDate(LocalDate.now());
		  transactionRepo.save(transDet);
		}
	
}
