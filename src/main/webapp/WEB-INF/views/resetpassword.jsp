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
  <h1>Hi "${account.customer.name}"</h1>
  <form action="/customer/resetpassword" method ="post">
  Old Password:<input type="text" name="oldPassword" placeholder="Enter your old password"><br><br>
  New Password:<input type="text" name="newPassword" placeholder="Enter your new password"><br><br>
  Confirm New Password:<input type="text" name="confirmPassword" placeholder="Enter your password again"><br><br>
   Submit:<input type="submit" value="submit">
  </form> 
</body>
</html>