<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "org.springframework.data.domain.Page" %>
<%@ page import ="com.bank.model.TransactionDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
   <h1>View transactions</h1>
     <table border="1">
        <th>Transaction Id</th>
        <th>Credit</th>
        <th>Debit</th>
        <th>Transaction Amount</th>
        <th>Transaction Date</th>
        <th>Transaction Type</th>
        <th>Actions</th>
        
        <%
   
        Page<TransactionDetails> transactions = (Page<TransactionDetails>) request.getAttribute("transactions");
        for(TransactionDetails transaction : transactions ){
	  
   %>
   
    <tr>
        <td><%=transaction.getTransactionId()%></td>
        <td><%=transaction.getCredit()%></td>
        <td><%=transaction.getDebit()%></td>
        <td><%=transaction.getTransactionAmount()%></td>
        <td><%=transaction.getTransactionDate()%></td>
        <td><%=transaction.getTransactionType()%></td>

    <%
    }
%> 
    </table>
        <a href="/customer/transactions?page=${transactions.number + 1}&size=${transactions.size}">
    <button>Load More</button>
       </a>
</body>
</html>