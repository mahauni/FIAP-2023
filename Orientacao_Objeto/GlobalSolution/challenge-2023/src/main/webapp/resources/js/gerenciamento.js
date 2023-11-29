function editarPaciente() {
    // Lógica de edição aqui
    alert("Função de edição ainda não implementada");
}

function excluirConsulta(id) {
    fetch("http://localhost:8080/test/appointment?action=deleteAppointment", {
        method: "post",
        data: id
    })
}
