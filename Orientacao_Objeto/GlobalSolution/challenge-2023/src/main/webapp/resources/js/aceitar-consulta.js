document.addEventListener('DOMContentLoaded', function() {
    var tabela = document.getElementById('tabela');

    var linhas = tabela.querySelectorAll('tbody tr');

    linhas.forEach(function(linha) {
        var cell = document.createElement('td');
        cell.classList.add('acao-cell'); // Adiciona uma classe para estilização
        var button = document.createElement('button');
        button.textContent = 'Aceitar';
        button.addEventListener('click', function() {
            var consulta = linha.cells[0].textContent;
            fetch("http://localhost/test/appointment?action=acceptAppointment", {method: "POST"})
        });
        cell.appendChild(button);
        linha.appendChild(cell);
    });
});


