package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDetailsRepository;
import com.bank.dao.TransactionDetailsRepository;
import com.bank.model.AccountDetails;
import com.bank.model.TransactionDetails;
import com.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
    
	@Autowired
	AccountDetailsRepository accountRepo;
	
	@Autowired
	TransactionDetailsRepository transactionDetailsRepo;
	
	@Override
	public AccountDetails validateBenificary(long receiverAccountNumber,long reEnteredNumber) {
		if(receiverAccountNumber==reEnteredNumber) {
		return accountRepo.findByAccountNumber(receiverAccountNumber);
	}
		return null;
	}

	@Override
	public Page<TransactionDetails> getTransactionsByPage(int page,int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
        Page<TransactionDetails> allTransactions = transactionDetailsRepo.findAll(pageRequest);
        return allTransactions;
	}
	
	
}
