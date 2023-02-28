package clientes;

public class Cliente {
    private String nome;
    private String endereco;
    private String dataNasc;


    public Cliente(String nome, String endereco, String dataNasc) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getDataNasc() {
        return dataNasc;
    }


    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    
}
