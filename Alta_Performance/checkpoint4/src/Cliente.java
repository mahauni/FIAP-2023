import java.util.Objects;

public class Cliente {
    private String nome;
    private String identificacao;
    private int numConta;
    private enumTipoConta tipoConta;
    private float saldo;

    public Cliente(String nome, int numConta, enumTipoConta tipoConta, float saldo) {
        this.nome = nome;
        this.identificacao = tipoConta.getTipoConta();
        this.numConta = numConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "nome='" + nome + '\'' +
                ", identificacao='" + identificacao + '\'' +
                ", numConta=" + numConta +
                ", tipoConta=" + tipoConta +
                ", saldo=" + saldo +
                '}';
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public enumTipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(enumTipoConta tipoConta) {
        this.identificacao = tipoConta.getTipoConta();
        this.tipoConta = tipoConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
