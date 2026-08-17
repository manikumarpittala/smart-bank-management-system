package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.dto.AdminLoginDTO;
import com.bank.dto.CreateAccountRequestDTO;
import com.bank.dto.CustomerUpdateDTO;
import com.bank.model.AccountDetails;
import com.bank.model.Admin;
import com.bank.model.CustomerDetails;
import com.bank.service.impl.AdminServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping("/createaccount")
	public String createAccount() {
		return "createaccount";
	}
	
	@PostMapping("/createaccount")
	public String createAccount(@ModelAttribute CreateAccountRequestDTO createAccountDTO) {
		adminService.createAccount(createAccountDTO);
		return "dashboard";
		}
	
	@GetMapping("/login")
	public String adminLogin() {
		return "admin";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute AdminLoginDTO adminLogin,HttpSession session) {
		Admin admin = adminService.login(adminLogin);
		session.setAttribute("admin", admin);
		if(admin!=null) {
		session.setAttribute("email", admin.getEmail());
        session.setAttribute("name", admin.getName());		
			return "secretkey";
		}else {
		return "invalidcredentials";
	}
	}
	
	@PostMapping("/secretkey")
	public String secretKey(@RequestParam String secretkey,HttpSession session) {
		if(adminService.secretKey(secretkey,session)==true) {
			return "dashboard";
		}else {
			return "invalidcredentials";
		}
	}
	
	@GetMapping("/logout")
	public String sessionInvalid(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login";
	}
   
	@GetMapping("/viewcustomers")
	public String viewAllCustomers(Model model){
		List<CustomerDetails> viewAllCustomers = adminService.viewAllCustomers();
         model.addAttribute("customers", viewAllCustomers);
		return "viewcustomers";
	}
	
	@GetMapping("/update")
	public String findCustomer(@RequestParam int id,Model model) {
		CustomerDetails customer = adminService.findCustomer(id);
		model.addAttribute("customer",customer);
		return "updatecustomer";
	}
	
	@PostMapping("/updatecustomer")
	public String updateCustomer(@ModelAttribute CustomerUpdateDTO customer) {
		adminService.updateCustomer(customer);
		return "redirect:/admin/viewcustomers";
	}
	
	
	@GetMapping("/viewaccounts")
	public String viewAllAccounts(Model model){
		List<AccountDetails> viewAllAccounts = adminService.viewAllAccounts();
		model.addAttribute("accounts",viewAllAccounts);
		return "viewaccounts"; 
	}
	
	@GetMapping("/deactivate")
	public String deactivateAccount(@RequestParam int id) {
		adminService.deactivateAccount(id);
	     return "redirect:/admin/viewaccounts";
	}
	
	@GetMapping("/activate")
	public String activateAccount(@RequestParam int id) {
		adminService.activateAccount(id);
	     return "redirect:/admin/viewaccounts";
	}

	
	
}
