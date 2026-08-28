package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		AccountDetails accountDetails = dashboardServ.accountDetails(accountNumber);
		session.setAttribute("freshAccountDetails", accountDetails);
		return "customer-dashboard";
	}
	
	@GetMapping("/logout")
	public String sessionInvalid(HttpSession session) {
		session.invalidate();
		return "redirect:/customer/login";
	}
	
	@GetMapping("/accountdetails")
	public String lastestAccountDetails(HttpSession session,Model model) {
		long accountNumber = (long) session.getAttribute("freshAccountNumber");
		AccountDetails accountDetails = dashboardServ.accountDetails(accountNumber);
         model.addAttribute("latestAccountDetails", accountDetails);
         return "account-details";
	}
	
	@GetMapping("/transfermoney")
	public String transferMoney() {
		return "transfer-money";
	}
	
	@GetMapping("/changepassword")
    public String resetPassword() {
    	return "redirect:/customer/resetpassword";
    }
}
