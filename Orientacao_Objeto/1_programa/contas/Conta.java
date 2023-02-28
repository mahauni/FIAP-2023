package contas;

import clientes.Cliente;

// abstract na class proibe a instancia da classe
public abstract class Conta { // superclass
    protected Cliente cliente;
    protected long numeroConta;
    protected double saldo;

    // contructor
    public Conta(Cliente cliente, long numeroConta) { // composicao
        this.cliente = cliente;
        this.numeroConta = numeroConta;
    }


    // metodos
    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }

        return false;
    }


    public void transferir(Conta conta, double valor) {
        boolean teste = this.sacar(valor);
        if (teste == true) {
            conta.depositar(valor);
        }
    }

    public abstract void exibirSaldo();
}
