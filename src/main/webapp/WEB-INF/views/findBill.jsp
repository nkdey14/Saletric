<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Bill</title>
</head>
<body>
<div align="center">
	<h3>Search Bill</h3>
	
	<form action="getBillingInfo" method="post">
		<table>
			<tr>
				<td>Enter Mob no.</td>
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