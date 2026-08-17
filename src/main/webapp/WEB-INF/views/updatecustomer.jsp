<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="com.bank.model.CustomerDetails" %>
<head>
<meta charset="UTF-8">
<title>Smart Bank</title>
</head>
<body>
  <% CustomerDetails customer= (CustomerDetails) request.getAttribute("customer"); %>
  <form action="/admin/updatecustomer" method="post">
    Customer Id:<input type=text name="customerId" value="<%= customer.getCustomerId()%>" readonly><br><br>
    Customer Name:<input type=text name="name" value="<%= customer.getName()%>"><br><br>
    AadhaarNumber:<input type="number" name="aadharNumber" value="<%= customer.getAadharNumber()%>"><br><br>
    PanNumber<input type="text" name="panNumber" value="<%= customer.getPanNumber()%>"><br><br>
    Address:<input type="text" name="address" value="<%= customer.getAddress()%>"><br><br>
    PhoneNumber:<input type="number" name="phoneNumber" value="<%= customer.getPhoneNumber()%>"><br><br>
    Email:<input type="email" name="email" value="<%= customer.getEmail()%>"><br><br>
    <button type="submit">UpdateCustomer</button>
  </form>
</body>
</html>