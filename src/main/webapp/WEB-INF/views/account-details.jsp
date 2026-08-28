<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bank.model.CustomerDetails" 
    import="com.bank.model.AccountDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
          <h1>Account Details</h1>
          <b>Account Number:</b> ${latestAccountDetails.accountNumber}<br><br>
           <b>Customer Name:</b> ${latestAccountDetails.customer.name}<br><br>
           <b>Balance      :</b> ${latestAccountDetails.balance}<br><br>
           <a href="/customer/dashboard">Dashboard</a>
</body>
</html>