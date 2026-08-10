<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
    <form action="/customer/resendotp" method="post">
    AccountNumber:<input type="number" name="accountNumber" value="${accountNumber}"><br><br>
    <button type="submit">Resend OTP</button>
</form>
</body>
</html>