package com.bank.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "account_number", nullable = false, unique = true)
    private long accountNumber;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_first", nullable = false)
    private boolean isFirst;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private double balance;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerDetails customer;

    @OneToMany(mappedBy = "account")
    private List<TransactionDetails> transactions;

    @OneToMany(mappedBy = "account")
    private List<Loan> loans;

    @OneToMany(mappedBy = "account")
    private List<OTP> otps;

	public AccountDetails(long accountNumber, String password, boolean isFirst, boolean isActive, double balance,
			CustomerDetails customer, List<TransactionDetails> transactions, List<Loan> loans, List<OTP> otps) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.isFirst = isFirst;
		this.isActive = isActive;
		this.balance = balance;
		this.customer = customer;
		this.transactions = transactions;
		this.loans = loans;
		this.otps = otps;
	}

	public AccountDetails(long accountNumber, String password, boolean isFirst, boolean isActive, double balance,
			CustomerDetails customer) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.isFirst = isFirst;
		this.isActive = isActive;
		this.balance = balance;
		this.customer = customer;
	}
    
    
    
}
