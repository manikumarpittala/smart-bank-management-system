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
   <h3>Account Number:<%= account.getAccountNumber() %></h3>
   <h3>Current Balance:<details>
    <summary>Show Balance</summary>
    <b><%= account.getBalance() %></b>
   </details></h3>
   <h3>Account Status:<%= account.isActive() %></h3>
   <a href="/customer/logout">
      <button>Logout</button>
    </a>
</body>
</html>