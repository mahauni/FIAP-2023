<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/menu.css">
    <title>Menu</title>
</head>
<body>
    <header class="header">
        <h1>Plano de Saude LUCVIC</h1>
        <div class="user-profile">
            <button class="logout-button" onclick="location.href='logout'">Sair</button>
        </div>
    </header>

    <div class="menu-title">
        <h2>Menu - Paciente</h2>
    </div>


    <div class="menu-container">
        <div class="menu-item">
            <button class="menu-button" onclick="location.href='agendamento.jsp'">
                <h2>Consulta</h2>
                <img src="resources/img/consulta.jpg" alt="Consulta">
            </button>
        </div>
        <div class="menu-item">
            <button class="menu-button" onclick="location.href='appointment?action=list'">
                <h2>Exames</h2>
                <img src="resources/img/exames.jpg" alt="Exames">
            </button>
        </div>
        <div class="menu-item">
            <button class="menu-button" onclick="location.href='rating'">
                <h2>Avaliacao</h2>
                <img src="resources/img/avaliacao.jpg" alt="Avaliacao">
            </button>
        </div>
    </div>

    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>

</body>
</html>