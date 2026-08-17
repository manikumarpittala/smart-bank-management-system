package com.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "customer_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDetails {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "customer_id")
	    private int customerId;

	    @Column(nullable = false)
	    private String name;

	    @Column(name = "aadhar_number", nullable = false, unique = true)
	    private String aadharNumber;

	    @Column(name = "pan_number", nullable = false, unique = true)
	    private String panNumber;

	    @Column(nullable = false)
	    private String address;

	    @Column(name = "phone_number", nullable = false, unique = true)
	    private String phoneNumber;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @OneToOne(mappedBy = "customer")
	    private AccountDetails account;

		public CustomerDetails(String name, String aadharNumber, String panNumber, String address, String phoneNumber,
				String email, AccountDetails account) {
			super();
			this.name = name;
			this.aadharNumber = aadharNumber;
			this.panNumber = panNumber;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.account = account;
		}

		@Override
		public String toString() {
			return "CustomerDetails [customerId=" + customerId + ", name=" + name + ", aadharNumber=" + aadharNumber
					+ ", panNumber=" + panNumber + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email="
					+ email + "]";
		}
	
		
	    
}
