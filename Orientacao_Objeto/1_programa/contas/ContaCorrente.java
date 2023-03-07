package contas;

import clientes.Cliente;
import interfaces.Produto;

public class ContaCorrente extends Conta {
    private double saldoInvestimento;

    public ContaCorrente(Cliente cliente, long numeroConta) {
        super(cliente, numeroConta);
    }


    public void investir(double valor, int tipo) {
        boolean teste = this.sacar(valor);
        if (teste == true) {
            switch (tipo) {
                case 1:
                    saldoInvestimento += valor * 1.01;
                    break;
                case 2:
                    saldoInvestimento += valor * 1.05;
                    break;
                default:
                    saldoInvestimento += valor * 1.1;
                    break;
            }
        }
    }

    public double getSaldoInvestimento() {
        return saldoInvestimento;
    }


    @Override
    public void exibirSaldo() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Data de nascimento: " + this.cliente.getDataNasc());
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Saldo investimento: " + this.saldoInvestimento);
        System.out.println("Saldo total: " + (this.saldo + this.saldoInvestimento));
        System.out.println("Data de abertura de conta: " + this.dataAbertura);
    }

    public void investimento(double valor, Produto produto) {
        boolean teste = this.sacar(valor);
    
        if (teste) {
            saldoInvestimento += produto.investir(valor);
        }
    }   
}
