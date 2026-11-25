package com.bank.service;

import org.springframework.data.domain.Page;

import com.bank.dto.TransferDetailsRequest;
import com.bank.dto.TransferDetailsResponse;
import com.bank.model.AccountDetails;
import com.bank.model.TransactionDetails;

public interface TransactionService {

	public AccountDetails validateBenificary(long receiverAccountNumber,long reEnteredNumber);
	
	public Page<TransactionDetails> getTransactionsByPage(int page,int size);
	
	public TransferDetailsResponse transferMoney(TransferDetailsRequest transDetails);
}
