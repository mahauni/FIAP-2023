package clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    private String nome;
    private String endereco;
    private Date dataNasc;

    public Cliente(String nome, String endereco, String dataNasc) throws ParseException {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc);
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


    public Date getDataNasc() {
        return dataNasc;
    }


    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    
}
