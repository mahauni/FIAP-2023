<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="resources/css/dados-exame.css">
    <title>Inserir Exames</title>
    
</head>
<body>

    <div class="menu-header">
        <div class="menu-items">
            <div class="menu-item">
                <a href="menu.jsp">Menu</a>
            </div>
            <div class="menu-item">
                <a href="exames.jsp">Exames</a>
            </div>
            <div class="menu-item">
                <a href="rating">Avaliacao</a>
            </div>
        </div>
        <div class="menu-item1">
            <button class="logout-button" onclick="location.href='logout'">Sair</button>
        </div>
</div>

    <div class="form-container">
        <h2>Inserir Dados de Exames</h2>
        <form id="exameForm" method="post" action="bio-data?action=makeExam">
            <input type="hidden" id="id" name="id" required>
            <label for="exame1">Exame 1:</label>
            <input type="text" id="exame1" name="exame1" required>

            <label for="exame2">Exame 2:</label>
            <input type="text" id="exame2" name="exame2" required>

            <button type="submit">Enviar</button>
        </form>
    </div>

    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>

    <script>
        var urlParams = new URLSearchParams(window.location.search);
        var idExame = urlParams.get('id');

        document.getElementById("id").value = idExame;
    </script>
</body>
</html>