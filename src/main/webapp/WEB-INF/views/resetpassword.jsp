<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
  <form action="/customer/resetpassword" method ="post">
  <h1>Hi "${sessionScope.account.customer.name}"</h1>
  Old Password:<input type="text" name="oldPassword" value="${password}"><br><br>
  New Password:<input type="text" name="newPassword" placeholder="Enter your new password"><br><br>
  Confirm New Password:<input type="text" name="confirmPassword" placeholder="Enter your password again"><br><br>
   Submit:<input type="submit" value="submit">
  </form> 
</body>
</html>