<!DOCTYPE html>
<html lang="en">
<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.AccountDetails" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Bank</title>
</head>
<body>
    <h1>View All Accounts</h1>
     <table border="1">
        <th>Account Id</th>
        <th>Account Number</th>
        <th>Balance</th>
        <th>Is Active</th>
        <th>Is First</th>
        <th>Customer Id</th>
        <th>Actions</th>
   
   <%
   
  List<AccountDetails> accounts =(List<AccountDetails>) request.getAttribute("accounts");
   for(AccountDetails account : accounts ){
	  
   %>
   
    <tr>
        <td><%=account.getAccountId()%></td>
        <td><%=account.getAccountNumber()%></td>
        <td><%=account.getBalance()%></td>
        <td><%=account.isActive()%></td>
        <td><%=account.isFirst()%></td>
        <td><%=account.getCustomer().getCustomerId()%></td>
        <td><a href="deactivate?id=<%= account.getAccountId() %>">Deactivate</a>| <a href="activate?id=<%= account.getAccountId() %>">Activate</a> </td>
    </tr>
    <%
    }
%> 
    </table>
</body>
</html>