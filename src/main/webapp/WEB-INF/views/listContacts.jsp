<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Contacts</title>
</head>
<body>
<div align="center">
${msg}
<br>
<a href="searchContact"><input type="button" value="Search"></a>
<br><br>
	<h3>List of Contacts</h3>
	
 	<table border='1' cellspacing='1' cellpadding='8'>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mob no.</th>
			<th>City</th>
			<th>Source</th>
			<th>Edit</th>
			<th>Send Email</th>
			<th>Generate Bill</th>
		</tr>
		
		<c:forEach var="contact" items="${contacts}">
		
		<tr>
			<td>${contact.id}</td>
			<td><a href="contactInfoPage?id=${contact.id}">${contact.firstName}</a></td>
			<td>${contact.lastName}</td>
			<td>${contact.email}</td>
			<td>${contact.mobile}</td>
			<td>${contact.city}</td>
			<td>${contact.source}</td>
			<td><a href="updateContact?id=${contact.id}"><input type="button" value="Edit"></a></td>
			<td><a href="sendEmail?email=${contact.email}"><input type="button" value="Send Email"></a></td>
			<td><a href="generateBill?id=${contact.id}"><input type="button" value="Generate Bill"></a></td>
		</tr>
			
		</c:forEach>
	</table>    
</div>
<br>
</body>
</html>