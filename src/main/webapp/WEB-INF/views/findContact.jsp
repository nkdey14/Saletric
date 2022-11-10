<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Contact</title>
</head>
<body>
<div align="center">
	<h3>Search Contact</h3>
	
	<form action="getContactInfo" method="post">
		<table>
			<tr>
				<td>Enter Contact's Mob no.</td>
				<td><input type="text" name="mobile" placeholder="Enter Mob no."></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<br>
${msg}
</div>
</body>
</html>