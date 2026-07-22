package com.bank.model;

import java.time.LocalTime;

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
@Table(name = "otp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OTP {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int otpId;
		
		@Column(name = "otp_value", nullable = false)
		private String otpValue;
		
		@ManyToOne
		@JoinColumn(name = "account_id", nullable = false)
		private AccountDetails account;
		
		@Column(nullable = false)
		private String email;
		
		@Column(name = "issued_time", nullable = false)
		private LocalTime issuedTime;
		
		@Column(name = "expiration_time", nullable = false)
		private LocalTime expirationTime;
		
		@Column(name = "is_valid", nullable = false)
		private boolean isValid;

		public OTP(String otpValue, AccountDetails account, String email, LocalTime issuedTime,
				LocalTime expirationTime, boolean isValid) {
			super();
			this.otpValue = otpValue;
			this.account = account;
			this.email = email;
			this.issuedTime = issuedTime;
			this.expirationTime = expirationTime;
			this.isValid = isValid;
		} 
		
		
		
}
