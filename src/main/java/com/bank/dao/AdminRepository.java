package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

   public Admin findByEmail(String email);
	
}
