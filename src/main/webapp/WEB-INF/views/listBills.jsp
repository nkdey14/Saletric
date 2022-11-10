<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Bills</title>
</head>
<body>
<div align="center">
${msg}
<br>
<a href="searchBill"><input type="button" value="Search"></a>
<br><br>
	<h3>List of Bills</h3>
	
 	<table border='1' cellspacing='1' cellpadding='8'>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mob no.</th>
			<th>City</th>
			<th>Product</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Send Email</th>
		</tr>
		
		<c:forEach var="bill" items="${bills}">
		
		<tr>
			<td>${bill.id}</td>
			<td><a href="billingInfoPage?id=${bill.id}">${bill.firstName}</a></td>
			<td>${bill.lastName}</td>
			<td>${bill.email}</td>
			<td>${bill.mobile}</td>
			<td>${bill.city}</td>
			<td>${bill.product}</td>
			<td>${bill.quantity}</td>
			<td>${bill.price}</td>
			<td><a href="sendEmail?email=${bill.email}"><input type="button" value="Send Email"></a></td>
		</tr>
			
		</c:forEach>
	</table>    
</div>
<br>
</body>
</html>