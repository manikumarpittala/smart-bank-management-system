package com.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.OTP;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Integer>{

	public OTP findByOtpValue(int otp);

//	@Query("Select From OTP where account_id =?1")
	public List<OTP> findAllByAccountAccountId(int id);
}
