<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Details</title>
</head>
<body>
<div align="center">
${msg}
<br><br>
	<h3>Bill Details</h3><br>
	
	<table border='1' cellspacing='1' cellpadding='8'>
		<tr>
			<th>First Name</th>
			<td>${bill.firstName}</td>
			
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${bill.lastName}</td>
		</tr>
		<tr>
			<th>Email Id</th>
			<td>${bill.email}</td>
		</tr>
		<tr>
			<th>Mob no.</th>
			<td>${bill.mobile}</td>
		</tr>
		<tr>
			<th>City</th>
			<td>${bill.city}</td>
		</tr>
		<tr>
			<th>Product</th>
			<td>${bill.product}</td>
		</tr>
		<tr>
			<th>Quantity</th>
			<td>${bill.quantity}</td>
		</tr>
		<tr>
			<th>Price</th>
			<td>${bill.price}</td>
		</tr>
	</table>
	<br>
		<a href="sendEmail?email=${bill.email}"><input type="button" value="Send Email"></a>
		<a href="listAllBills"><input type="button" value="Back"></a>
	<br>
</div>
<br>
</body>
</html>