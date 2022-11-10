<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div align="center">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Cintrix</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</nav>

		<br>
	
	<img src="https://media.istockphoto.com/vectors/customer-relationship-management-vector-id1201847037?k=20&m=1201847037&s=170667a&w=0&h=zaIiwuUYQdV2ICotjMTrEEc9v0189KSGDhfsmboAZIs=" alt="background-image">
	
	<br>
	
	<h3>Login here.....</h3><br>
	
	<form action="verifyLogin" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	${msg}
</div>
</body>
</html>