package com.bank.model;

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
@Table(name = "loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "loan_id")
		private int loanId;
		
		@Column(name="loan_amount",nullable = false)
		private double loanAmount;
		
		@Column(name="loan_type",nullable = false)
		private String loanType;
		
		@Column(nullable = false)
		private String status; 
		
		@ManyToOne
		@JoinColumn(name = "account_id", nullable = false)
		private AccountDetails account;

		public Loan(double loanAmount, String loanType, String status, AccountDetails account) {
			super();
			this.loanAmount = loanAmount;
			this.loanType = loanType;
			this.status = status;
			this.account = account;
		}
	
		
	}

