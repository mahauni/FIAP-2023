<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/avaliacao.css">
    <title>Avaliacao</title>
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
                <a href="appointment?action=list">Exames</a>
            </div>
        </div>
        <div class="menu-item1">
            <button class="logout-button" onclick="location.href='logout'">Sair</button>
        </div>
    </div>

    <div class="formulario-container">
        <h2>Avaliacao</h2>
        <form id="forms" action="rating" method="post">

            <select id="tipoConsulta" name="consulta" onchange="carregarMaquinas()"  required>
                    <option value="" disabled selected>Selecione uma consulta</option>
                    <c:forEach items="${exams}" var="e">
                        <option id=${e.type.name} value=${e.id}>Consulta ${e.type.name}</option>
                    </c:forEach>
            </select>

            <div id="maquinasContainer"></div>

            <input type="submit" value="Avaliar">
        </form>
    </div>
    
    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>

    <script>
        function carregarMaquinas() {
            var tipoConsultaSelect = document.getElementById("tipoConsulta");
            var consultaId = tipoConsultaSelect.options[tipoConsultaSelect.selectedIndex].id;
            var maquinasContainer = document.getElementById("maquinasContainer");

            console.log(consultaId);
            console.log(tipoConsultaSelect);

            // Mapeamento de máquinas para cada tipo de consulta
            var maquinas = {
                'Ortopedista': ['Espessometro', 'Transdutor'],
                'Dermatologia': ['Luz de Wood', 'Endoscopio'],
                'Oftalmologia': ['Refrator', 'Oftalmoloscopio']
            };

            // Limpar as opções existentes
            maquinasContainer.innerHTML = "";

            // Adicionar as opções de máquinas com notas para o tipo de consulta selecionado
            for (var i = 0; i < maquinas[consultaId].length; i++) {
                var maquinaLabel = document.createElement("label");
                maquinaLabel.innerHTML = maquinas[consultaId][i] + ": ";

                var notaSelect = document.createElement("select");
                notaSelect.name = "notaMaquina" + i;

                for (var nota = 1; nota <= 5; nota++) {
                    var notaOption = document.createElement("option");
                    notaOption.value = nota;
                    notaOption.text = nota;
                    notaSelect.appendChild(notaOption);
                }

                maquinasContainer.appendChild(maquinaLabel);
                maquinasContainer.appendChild(notaSelect);
                maquinasContainer.appendChild(document.createElement("br"));
            }
        }
    </script>
</body>
</html>