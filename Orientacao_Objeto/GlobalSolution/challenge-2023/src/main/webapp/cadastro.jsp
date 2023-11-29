<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/cadastro.css">
    <title>Cadastro</title>
</head>
<body>
    <header class="header">
        <h1>Plano de Saude LUCVIC</h1>
    </header>

    <div class="container">
        <h2>Cadastro</h2>

        <form id="cadastroForm" action="user" method="post">
            <input type="hidden" value="registerUser" name="action">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" required>

            <label for="role">Escolha o tipo de cadastro:</label>
            <select id="role" name="role">
                <option value="MEDIC">Medico</option>
                <option value="PATIENT">Paciente</option>
            </select>

            <button type="submit">Cadastrar</button>
        </form>

        <p>Ja tem uma conta? <a href="login.jsp">Faca login</a></p>
    </div>

    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>

    
    <script src="resources/js/cadastro.js"></script>
</body>
</html>