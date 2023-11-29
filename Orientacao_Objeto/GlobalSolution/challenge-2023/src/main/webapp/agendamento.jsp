<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/agendamento.css"> 
    <title>Agendamento de Consulta</title>
</head>
<body>
    <div class="menu-header">
        <div class="menu-items">
            <div class="menu-item">
                <a href="menu.jsp">Menu</a>
            </div>
            <div class="menu-item">
                <a href="appointment?action=list">Exames</a>
            </div>
            <div class="menu-item">
                <a href="rating">Avaliacao</a>
            </div>
        </div>
        <div class="menu-item1">
            <button class="logout-button" onclick="location.href='logout'">Sair</button>
        </div>
</div>
    

    <div class="agendamento-container">
       
        <h1>Agendamento de Consulta</h1>

        <form id="agendamento-form" action="appointment" method="post">
            <input type="hidden" value="requestAppointment" name="action">
            <label for="appointType">Especialidade:</label>
            <select id="especialidade" name="appointType">
                <option value="Oftalmologia">Oftalmologia</option>
                <option value="Dermatologia">Dermatologia</option>
                <option value="Ortopedista">Ortopedista</option>
            </select>

            <label for="appointTime">Data:</label>
            <input type="date" id="data" name="appointTime" min="2000-01-01" max="2024-12-31" required>

            <label for="message">Mensagem:</label>
            <textarea id="mensagem" name="message" rows="4" required></textarea>

            <input type="submit" value="Agendar" id="agendar-btn">
        </form>
       

        <div id="mensagem-sucesso" class="mensagem-sucesso">
            <img src="icone-concluido.png" alt="icone de Conclu�do">
            <p>Consulta agendada com sucesso!<br>Agora so esperar pela confirmacao do medico.</p>
        </div>

    </div>

    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>


    <script src="agendamento.js"></script>  
</body>
</html>