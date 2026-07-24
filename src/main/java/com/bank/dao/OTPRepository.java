package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.OTP;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Integer>{

}
