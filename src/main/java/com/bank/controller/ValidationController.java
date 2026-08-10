package com.bank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.model.AccountDetails;
import com.bank.service.impl.ValidationServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class ValidationController {
	
	@Autowired
	ValidationServiceImpl validServ;
	
	
	@GetMapping("/login")
	public String loginPage() {
	    return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam long accountNumber,
	                    @RequestParam String password,
	                    HttpSession session) {

		AccountDetails account = validServ.login(accountNumber, password);
           session.setAttribute("account", account);
	    if (account != null ) {
	        session.setAttribute("accountNumber", accountNumber);
	        session.setAttribute("password", password);
           
	        return "loginwithotp";
	    }

	    session.setAttribute("msg", "Invalid accountNumber or Password");
	    return "accountinactive";
	}
	
	@PostMapping("/verifyOtp")
	public String verifyOTP(@RequestParam int otp,@RequestParam long accountNumber) {
		if(validServ.verifyOTP(otp,accountNumber).equals("resetpassword")) {
			return "resetpassword";
		}
		else if(validServ.verifyOTP(otp,accountNumber).equals("directlogin")) {
			return "dashboard";
		}
		return "invalid";
	}
	
	@GetMapping("/resendotp")
	public String resendOtp() {
	    return "resendotp";
	}
	
	@PostMapping("/resendotp")
	public String resendOtps(long accountNumber) {
		validServ.resendOtp(accountNumber);
		return "loginwithotp";
	}
	
	@GetMapping("/resetpassword")
	public String resetPassword() {
		return "resetpassword";
	}
	
	@PostMapping("/resetpassword")
	public String changePassword(@RequestParam String oldPassword,@RequestParam String newPassword,@RequestParam String confirmPassword,HttpSession session) {
		long attribute = (long) session.getAttribute("accountNumber");
         if(validServ.changePassword(attribute, oldPassword, newPassword, confirmPassword).equals("done")){
        	 return "dashboard";
         }else {
        	 return "new password and old password are not same";
         }
	}
	
}
