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
   
   <% AccountDetails account = (AccountDetails) session.getAttribute("freshAccountDetails");
   CustomerDetails cust =account.getCustomer();%>
   <h1>Hi <%= cust.getName() %></h1>
   <a href="/customer/accountdetails">Account Details</a><br><br>
   <a href="/customer/transfermoney">Transfer Money</a><br><br>
   <a href="/customer/transactions">Transactions</a><br><br>
   <a href="/customer/changepassword">ChangePassword</a><br><br>   
   <a href="/customer/logout">
      <button>Logout</button>
    </a>
</body>
</html>