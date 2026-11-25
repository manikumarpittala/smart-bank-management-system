<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Bank</title>
</head>
<body>
    <form action="/customer/validateBenificiary" method="post">
     Benificiary AccountNumber:<input type="password" name="receiverAccountNumber" placeholder="enter receiver AccountNumber"><br><br>
     Re-enter AccountNumber   :<input type="text" name="reEnteredAccountNumber" placeholder="re-enter receiver AccountNumber" value="${valid.accountNumber}"><br><br>
     <button type="submit">Validate</button><br><br>
              </form>
    <form action="/customer/transferMoney" method="post">
     <b>Sender AccountNumber</b>     : <input type="text" name="senderAccountNumber" value = "${accountNumber}"><br><br>
                To<br><br>
     <b>Benificiary Name</b>         : ${valid.customer.name}<br><br>
     <b>Benificiary AccountNumber</b>: <input type="text" name="benificaryAccountNumber" placeholder="re-enter receiver AccountNumber" value="${valid.accountNumber}"><br><br>
     <b>Transfer Amount</b>:<input type="number" min="1" name="transferAmount" placeholder="enter transferAmount" required><br><br>
     <b>Remarks</b>:<input type="text" name="transferType" placeholder="enter remarks" required><br><br> 
     <button type="submit">Transfer Money</button>
    </form>
</body>
</html>