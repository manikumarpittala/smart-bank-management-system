<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>-
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
    <form action="/customer/transferMoney" method="post">
     <b>Sender AccountNumber</b>:<input type="text" name="senderAccoutNumber" value="${verify.senderAccoutNumber}"><br><br>
     <b>Benificiary AccountNumber</b>:<input type="text" name="receiverAccountNumber" value="${verify.benificaryAccoutNumber}"><br><br>
     <b>Benificiary Name</b>:<input type="text" name="receiverName" value="${verify.benificaryName}"><br><br>
     <b>Transfer Amount:</b><input type="text" name="transferAmount" value="${verify.transferAmount}"><br><br>
     <!-- <input type="text" name="" placeholder="enter transferAmount"> -->
      <button type="submit">Conform Transfer Money</button>
    </form>
</body>
</html>