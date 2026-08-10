<%@page import="ch.qos.logback.core.model.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
   <form action="/customer/verifyOtp" method="post">
   AccountNumber:<input type="number" name="accountNumber" value="${accountNumber}"><br><br>
   Password:<input type="hidden" name="password" value="${password}"><br><br>
   OTP:<input type="text" name="otp"><br><br>
   Verify Otp:<input type="submit" value="Login">
    <a href="/customer/resendotp?accountNumber=${accountNumber}">
    Resend OTP
</a>
   </form>
</body>
</html>