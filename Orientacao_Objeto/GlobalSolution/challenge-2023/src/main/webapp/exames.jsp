<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/exames.css">
    <title>Exames</title>
</head>
<body>
    
        <div class="menu-header">
            <div class="menu-items">
                <div class="menu-item">
                    <a href="menu.jsp">Menu</a>
                </div>
                <div class="menu-item">
                    <a href="agendamento.jsp">Agendamento de Consulta</a>
                </div>
                <div class="menu-item">
                    <a href="rating">Avaliacao</a>
                </div>
            </div>
            <div class="menu-item1">
                <button class="logout-button" onclick="location.href='logout'">Sair</button>
            </div>
    </div>
    

    <div class="conteudo-container">
        <div class="conteudo-header">
            <h1>Exame</h1>
        </div>

        <div class="conteudo-tabela">
            <table>
                <thead>
                    <tr>
                        <th>Consulta</th>
                        <th>Pendencia</th>
                        <th>Exame</th>
                        <th>Dados Biometricos</th>
                    </tr>
                </thead>
                <tbody>
               
                    <c:forEach items="${exams}" var="e">
                        <tr>
                            <td>${e.type.name}</td>
                            <td>${e.pendency.getDetails()}</td>
                            <td>${e.id}</td>
                            <td><button onclick="obterIdExame(${e.id})">Registrar dados do exame</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <footer class="footer">
        <p>Plano de Saude Notre Dame &copy; 2023</p>
    </footer>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var linhasTabela = document.querySelectorAll(".conteudo-tabela tbody tr");

            linhasTabela.forEach(function (linha) {
                var exameCell = linha.querySelector("td:nth-child(3)");

                if (exameCell.textContent.trim() === "Dados pendentes") {
                    linha.addEventListener("click", function () {
                        var link = this.getAttribute("data-link");
                        if (link) {
                            window.location.href = link;
                        }
                    });

                    linha.style.cursor = "pointer";
                    linha.style.textDecoration = "underline";
                    linha.style.color = "blue";
                }
            });
        });

        function obterIdExame(id) {
            window.location.href = 'dados-exame.jsp?id=' + id;
        }
    </script>
</body>
</html>