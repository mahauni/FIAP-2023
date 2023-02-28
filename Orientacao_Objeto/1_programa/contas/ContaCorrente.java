package contas;

import clientes.Cliente;

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
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Saldo investimento: " + this.saldoInvestimento);
        System.out.println("Saldo total: " + (this.saldo + this.saldoInvestimento));
    }

    
}
