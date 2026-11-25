package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDetailsRepository;
import com.bank.dao.TransactionDetailsRepository;
import com.bank.dto.TransferDetailsRequest;
import com.bank.dto.TransferDetailsResponse;
import com.bank.model.AccountDetails;
import com.bank.model.TransactionDetails;
import com.bank.service.TransactionService;
import com.bank.utils.TransactionUpdate;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
    
	@Autowired
	AccountDetailsRepository accountRepo;
	
	@Autowired
	TransactionDetailsRepository transactionDetailsRepo;
	
	@Autowired
	TransactionUpdate transactionUpdate;
	
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
	
	public TransferDetailsResponse transferMoney(TransferDetailsRequest transDetails) {
		System.out.println("Ochinaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		AccountDetails senderAccount = accountRepo.findByAccountNumber(transDetails.getSenderAccountNumber());
		AccountDetails benificiaryAccount = accountRepo.findByAccountNumber(transDetails.getBenificaryAccountNumber());
		if(senderAccount.getBalance() >= transDetails.getTransferAmount()) {
		  senderAccount.setBalance(senderAccount.getBalance()-transDetails.getTransferAmount());
		  benificiaryAccount.setBalance(benificiaryAccount.getBalance()+transDetails.getTransferAmount());
		  TransferDetailsResponse trans = new TransferDetailsResponse();
		   trans.setBenificaryName(benificiaryAccount.getCustomer().getName());
		   trans.setBenificaryAccoutNumber(benificiaryAccount.getAccountNumber());
		   trans.setSenderAccoutNumber(senderAccount.getAccountNumber());
		   trans.setTransferAmount(transDetails.getTransferAmount());
		   transactionUpdate.debitUpdate(transDetails.getBenificaryAccountNumber(), transDetails.getTransferAmount(), transDetails.getTransferType());
		   System.out.println("debit doneeeeeeeeee");
		   transactionUpdate.creditUpdate(transDetails.getBenificaryAccountNumber(), transDetails.getTransferAmount());
		   System.out.println("creditttttttttttt doneeeeeeeeee");
		   return trans;
		}
		return null;
	}
	
	
}
