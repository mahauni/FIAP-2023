<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/SimulationCRUD/editUser" method="post">
		<label>Name</label> <br> <input type=text name="name" value="${ user.name }"> <br> 
		<label>Password</label> <br> <input type=text name="passwd" value="${ user.passwd }"> <br> 
		<label>Email</label> <br> <input type=text name="email" value="${ user.email }"> <br> 
		<label>Telephone</label> <br> <input type=text name="telephone" value="${ user.telephone }"> <br>
		<input type="hidden" name="id" value="${ user.id }"> <br>
		<br>
		<input type="submit" name="enviar" value="Send">
		<input type="reset" name="limpar" value="Clear"> 
	</form>
</body>
</html>