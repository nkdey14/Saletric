<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose Email</title>
<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
</head>
<body>
<div align="center">
${msg}
<br><br>
<h3>New Email</h3><br>
	<form action="triggerEmail" method="post">
		<table>
			<tr>
				<td>To</td>
				<td><input type="email" name="email" value="${email}" readonly></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>Message</td>
				<td><textarea id="content" name="content" rows="10" cols="50"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Send"></td>
			</tr>
		</table>
	</form>
</div>

<!--  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.2.0/classic/ckeditor.js"></script>
<script>
                        ClassicEditor
                                .create( document.querySelector( '#content' ) )
                                .then( editor => {
                                        console.log( editor );
                                } )
                                .catch( error => {
                                        console.error( error );
                                } );
</script>      -->
<br>                
</body>
</html>