package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.model.AccountDetails;
import com.bank.service.impl.CustomerDashboardServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerDashboardController {
	
	@Autowired
	CustomerDashboardServiceImpl dashboardServ;

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		long accountNumber =(long) session.getAttribute("freshAccountNumber");
		AccountDetails accountDetails = dashboardServ.dashboard(accountNumber);
		session.setAttribute("freshAccountDetails", accountDetails);
		return "customer-dashboard";
	}
	
	@GetMapping("/logout")
	public String sessionInvalid(HttpSession session) {
		session.invalidate();
		return "redirect:/customer/login";
	}
}
