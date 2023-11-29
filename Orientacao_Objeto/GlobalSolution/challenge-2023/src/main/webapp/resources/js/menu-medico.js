function abrirAba(abaId) {
    // Oculta todas as abas
    var abas = document.querySelectorAll('.aba');
    for (var i = 0; i < abas.length; i++) {
        abas[i].style.display = 'none';
    }

    // Exibe a aba correspondente
    var abaSelecionada = document.getElementById('aba' + abaId.charAt(0).toUpperCase() + abaId.slice(1));
    abaSelecionada.style.display = 'block';

    if (abaSelecionada == "abaAceitarConsulta") {
        fetch("http://localhost:8080/test/appointment?action=list")
    }

    // Exibe a camada de fundo
    document.getElementById('overlayFundo').style.display = 'block';
}

function fecharAba() {
    // Oculta a aba e a camada de fundo
    var abas = document.querySelectorAll('.aba');
    for (var i = 0; i < abas.length; i++) {
        abas[i].style.display = 'none';
    }
    document.getElementById('overlayFundo').style.display = 'none';
}

function selecionarTipoConsulta() {
    var tipoConsulta = document.getElementById('tipoConsulta').value;
    var maquinasDropdown = document.getElementById('maquinas');

    // Limpa o dropdown de máquinas
    maquinasDropdown.innerHTML = '<option value="" selected disabled>Selecione...</option>';

    if (tipoConsulta === 'oftalmologia') {
        // Preenche as máquinas para Oftalmologia
        maquinasDropdown.innerHTML += '<option value="refrator">Refrator e Ofrtalmoloscópio</option>';
    } else if (tipoConsulta === 'dermatologica') {
        // Preenche as máquinas para Dermatológica
        maquinasDropdown.innerHTML += '<option value="lampadaWood">Lâmpada de Wood (LW) e Endoscópio</option>';
    } else if (tipoConsulta === 'ortopedista') {
        // Preenche as máquinas para Ortopedista
        maquinasDropdown.innerHTML += '<option value="espessometro">Espessômetro e Transdutor Convexo</option>';
    }

    // Exibe as próximas seções
    document.getElementById('secaoMaquinas').style.display = 'block';
    document.getElementById('secaoData').style.display = 'block';
    document.getElementById('agendarButton').style.display = 'block';
}

function agendarMaquina() {
    // Lógica para agendar a máquina
    var tipoConsulta = document.getElementById('tipoConsulta').value;
    var maquinaSelecionada = document.getElementById('maquinas').value;
    var dataSelecionada = document.getElementById('data').value;

    alert('Máquina ' + maquinaSelecionada + ' agendada para ' + tipoConsulta + ' em ' + dataSelecionada);
}


function aceitarConsulta(consulta) {
    alert("Consulta aceita: " + consulta);
    // Adicione aqui a lógica para processar a aceitação da consulta
}
        
document.addEventListener('DOMContentLoaded', function() {
    // Obtém a referência para a tabela
    var tabela = document.getElementById('tabela');

    // Obtém todas as linhas da tabela, excluindo o cabeçalho
    var linhas = tabela.querySelectorAll('tbody tr');

    // Itera sobre as linhas e adiciona um botão "Aceitar" em cada linha
    linhas.forEach(function(linha) {
        // Cria um elemento de célula para a coluna de ação
        var cell = document.createElement('td');
        cell.classList.add('acao-cell'); // Adiciona uma classe para estilização
        var button = document.createElement('button');
        button.textContent = 'Aceitar';
        button.addEventListener('click', function() {
            // Lógica para lidar com o clique no botão "Aceitar"
            var consulta = linha.cells[0].textContent;
            alert('Consulta aceita: ' + consulta);
            // Adicione aqui a lógica para processar a aceitação da consulta
        });
        cell.appendChild(button);
        linha.appendChild(cell);
    });
});


