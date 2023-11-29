<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/menu-medico.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
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
        <div class="menu-item" onclick="abrirAba('agendarMaquinas')">
            <h2>Agendar Maquinas</h2>
        </div>
        <div class="menu-item" onclick="location.href='appointment?action=listAppointments'">
            <h2>Gerenciar Paciente</h2>
        </div>
        <div class="menu-item" onclick="location.href='tech'">
            <h2>Tecnologias</h2>
        </div>
        <div class="menu-item1">
            <button class="logout-button" onclick="location.href='logout'">Sair</button>
        </div>
    </div>
    </div>

    <div class="conteudo-aba">
        

        <div class="aba" id="abaAgendarMaquinas">
            <h2>Agendar Maquina</h2>
        
            <div class="secao-agendamento">
                <label for="tipoConsulta">Selecione o tipo de consulta:</label>
                <select id="tipoConsulta" onchange="selecionarTipoConsulta()">
                    <option value="" selected disabled>Selecione...</option>
                    <option value="oftalmologia">Oftalmologia</option>
                    <option value="dermatologica">Dermatologica</option>
                    <option value="ortopedista">Ortopedista</option>
                </select>
            </div>
        
            <div class="secao-agendamento" id="secaoMaquinas" style="display: none;">
                <label for="maquinas">Selecione as máquinas:</label>
                <select id="maquinas"> </select>
            </div>
        
            <div class="secao-agendamento" id="secaoData" style="display: none;">
                <label for="data">Escolha a data:</label>
                <input type="date" id="data">
            </div>
        
            <div id="agendarButton" class="secao-agendamento" style="display: none;">
                <button onclick="agendarMaquina()">Agendar</button>
            </div>
        </div>

        </div>
    </div>

    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>

    <script src="resources/js/menu-medico.js"></script>
    
</body>
</html>