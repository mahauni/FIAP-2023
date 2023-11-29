<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/tecnologias.css">
    <title>Menu Medico</title>
</head>
<body>

    <div class="overlay-fundo" id="overlayFundo"></div>

    <div class="menu-container">
        <div class="menu-title">
            <h2>Menu - Medico</h2>
        </div>
        <div class="menu-item" onclick="location.href='appointment?action=listExams'">
            <h2>Aceitar Consulta</h2>
        </div>
        <div class="menu-item" onclick="location.href='menu-medico.html'">
            <h2>Agendar Maquinas</h2>
        </div>
        <div class="menu-item"onclick="location.href='appointment?action=listAppointments'">
            <h2>Gerenciar Paciente</h2>
        </div>
		<div class="menu-item">
            <h2>Tecnologias</h2>
        </div>
        <div class="menu-item1">
            <button class="logout-button" onclick="location.href='logout'">Sair</button>
        </div>

    </div>

    <div class="container">
        <h2>Tecnologias</h2>
        <ul>
            <li>
                <strong>Nome:</strong> React
                <strong>Descricao:</strong> 
            </li>
            <c:forEach items="${techs}" var="t">
                <li>
                    <strong>Nome:</strong> ${t.tecName}
                    <p><strong>Descricao:</strong> ${t.description} </p>
                </li>
            </c:forEach>
        </ul>
    </div>

    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>

    <script>
        function fazerLogout() {
        // Redirecionar para a tela de login
        window.location.href = "login.html";
    }
    </script>
</body>
</html>
