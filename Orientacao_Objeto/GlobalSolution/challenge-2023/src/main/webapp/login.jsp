<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/login.css">
    <title>Login</title>
</head>
<body>
    <header class="header">
        <h1>Plano de Saude LUCVIC</h1>
    </header>

    <div class="login-container">
        
            <h2>Login</h2>
        
        
            <form action="login" method="post">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="senha">Senha:</label>
                <input type="password" id="password" name="password" required>

                <button type="submit">Entrar</button>
            </form>

            <p>Nao tem uma conta? <a href="cadastro.jsp">Cadastre-se</a></p>
        
    </div>

    <footer class="footer">
        <p>Plano de Saude LUCVIC &copy; 2023</p>
    </footer>

    <script src="resources/js/script.js"></script>
</body>
</html>