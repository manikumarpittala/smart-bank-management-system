package com.bank.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
    @Column(nullable = false, unique = true)
	private String name;
	
    @Column(nullable = false, unique = true)
	private String email;
	
    @Column(nullable = false)
	private String password;
	
    @Column(nullable = false)
	private String role;
	
    @Column(name = "created_at", nullable = false)
	private LocalDate createdAt;

	public Admin(String name, String email, String password, String role, boolean isActive, LocalDate createdAt) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
	}
	
    
}
