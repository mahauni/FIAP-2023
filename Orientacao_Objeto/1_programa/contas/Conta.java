package contas;

import java.util.Calendar;
import java.util.Date;

import clientes.Cliente;

// abstract na class proibe a instancia da classe
public abstract class Conta { // superclass
    protected final Cliente cliente;
    protected final long numeroConta;
    protected double saldo;
    protected Date dataAbertura = Calendar.getInstance().getTime();
    private static long contador;

    // contructor
    public Conta(Cliente cliente, long numeroConta) { // composicao
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        contador += 1;
    }

    public static void exibirContador() {
        System.out.println("Contas: " + contador);
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
