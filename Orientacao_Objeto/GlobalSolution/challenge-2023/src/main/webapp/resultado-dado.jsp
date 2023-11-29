<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/dados.css">
    <title>Menu Medico</title>
</head>
<body>

    <div class="overlay-fundo" id="overlayFundo"></div>

    <div class="menu-container">
        <div class="menu-title">
            <h2>Menu - Medico</h2>
        </div>
        <div class="menu-item" onclick="abrirAba('aceitarConsulta')">
            <h2>Aceitar Consulta</h2>
        </div>
        <div class="menu-item" onclick="location.href='menu-medico.html'">
            <div class="fundo-aba">
            <h2>Agendar Maquinas</h2>
            </div>
        </div>
        <div class="menu-item">
            <h2>Gerenciar Paciente</h2>
        </div>
        <div class="menu-item" onclick="location.href='tecnologias.html'">
            <h2>Tecnologias</h2>
        </div>
        <div class="menu-item1">
            <button class="logout-button" onclick="fazerLogout()">Sair</button>
        </div>
    </div>


    <div class="form-container" id="form-container">
        <h2>Inserir Dados de Exames</h2>
            <form method="post" action="appointment">
                <input type="hidden" name="action" value="finalizeExam">
                <input type="hidden" name="id" value="<c:out value="${idAppoint}"/>">
                <label for="dados">Dados da outra pagina</label>
                <c:forEach items="${data}" var="d">
                    <p>
                        ${d.data}
                    </p>
                </c:forEach>

                <label for="outrosCampos">Exame 2:</label>
                <input type="outrosCampos" id="outrosCampos" name="resultadoExame" placeholder="Digite aqui">

                <button id="enviar-btn">Enviar</button>
            </form>
    </div>


    <footer class="footer">
        <p>Plano de Saúde LUCVIC &copy; 2023</p>
    </footer>

    <script>
        var urlParams = new URLSearchParams(window.location.search);
        var idExame = urlParams.get('id');

        document.getElementById("id").value = idExame;
    </script>
</body>
</html>
