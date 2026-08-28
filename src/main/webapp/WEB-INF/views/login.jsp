<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
<link rel="stylesheet" href="login.css">
</head>
   
<body>
 <div class="fulldiv">
      <h1>Welcome to Our Smart Bank</h1>
      <marquee>Please Login to experience our feature</marquee>
    <div class="parent">
      <h1>Login</h1>
      <form action="/customer/login" method="post">
      AccountNumber:<input type="number" name="accountNumber" placeholder="Enter your accountnumber"><br><br>
      Password:<input type="text" name="password" placeholder="Enter your password"><br><br>
      <div class="parentbutton">
        <button type="submit">Login</button>
        </form>
      </div>
    </div>
 </div>
</body>
</html>