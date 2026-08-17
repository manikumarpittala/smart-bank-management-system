<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="com.bank.model.AccountDetails" %>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
  <% AccountDetails account= (AccountDetails) request.getAttribute("account"); %>
  <form action="/admin/updatecustomer">
   <input type="text" name="customerId" value="" readonly>
  </form>
</body>
</html>