<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="control.*, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>
	List Users Registered:
	<ol>
		<c:forEach items="${users}" var="user">
			<li>${user.name} - ${user.email} - 
				<fmt:formatDate value="${user.loginDate}" />
				<a href="/SimulationCRUD/removeUser?id=${ user.id }">remove</a>
				<a href="/SimulationCRUD/editUser?id=${ user.id }">edit</a>
			</li>
		</c:forEach>
	</ol>
	
	<a href="/SimulationCRUD/newUser">New</a>
</body>
</html>