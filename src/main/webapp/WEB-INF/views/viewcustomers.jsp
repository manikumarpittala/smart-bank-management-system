<!DOCTYPE html>
<html lang="en">
<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.CustomerDetails" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Bank</title>
</head>
<body>
   <div>
     <h1>View All Customers</h1>
     <table border="1">
        <th>Customer id</th>
        <th>Name</th>
        <th>Aadhar Number</th>
        <th>Pan Number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone Number</th>
         <th>Actions</th>
        
	  <%
	   List<CustomerDetails> allCustomers = (List<CustomerDetails>) request.getAttribute("customers");
	     
	    for (CustomerDetails customer : allCustomers) {
	    	
	%>

	<tr>
	    <td><%= customer.getCustomerId() %></td>
	    <td><%= customer.getName() %></td>
	    <td><%= customer.getAadharNumber() %></td>
	    <td><%= customer.getPanNumber() %></td>
	    <td><%= customer.getEmail() %></td>
	    <td><%= customer.getAddress() %></td>
	    <td><%= customer.getPhoneNumber() %></td>
	    <td> <a href="update?id=<%= customer.getCustomerId() %>">Update Customer</a></td>
	</tr>

<%
    }
%>     
     </table>
   </div>

</body>
</html>