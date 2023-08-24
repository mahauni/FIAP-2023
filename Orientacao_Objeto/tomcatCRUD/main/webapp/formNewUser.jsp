<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	New User:
	<br>
	<br>
	<form action="/SimulationCRUD/newUser" method="post">
		<label>Name</label> <br> <input type=text name="name"> <br> 
		<label>Password</label> <br> <input type=text name="passwd"> <br> 
		<label>Email</label> <br> <input type=text name="email"> <br> 
		<label>Telephone</label> <br> <input type=text name="telephone"> <br>
		<br>
		<input type="submit" name="enviar" value="Send">
		<input type="reset" name="limpar" value="Clear"> 
	</form>
</body>
</html>