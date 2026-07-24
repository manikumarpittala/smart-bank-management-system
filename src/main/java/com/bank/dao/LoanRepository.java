package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
