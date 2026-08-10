package com.bank.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetails {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int transactionId;
		
		@Column(name="transaction_type",nullable = false)
		private String transactionType;
		
//		@Min(value = 0, message = "Transaction amount must be greater than zero")
		@Column(name="transaction_amount",nullable = false)
		private int transactionAmount;
		
		@ManyToOne
		@JoinColumn(name = "account_id", nullable = false)	
		private AccountDetails account;
		
		@Column(name="transaction_date",nullable = false)
		private LocalDate transactionDate;
		
		@Column(nullable = false)
		private int debit;
		
		@Column(nullable = false)
		private int credit;
		
		public TransactionDetails(String transactionType,int transactionAmount,
				AccountDetails account, LocalDate transactionDate, int debit, int credit) {
			super();
			this.transactionType = transactionType;
			this.transactionAmount = transactionAmount;
			this.account = account;
			this.transactionDate = transactionDate;
			this.debit = debit;
			this.credit = credit;
		}
}
