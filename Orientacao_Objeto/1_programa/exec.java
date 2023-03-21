import java.text.ParseException;

import clientes.Cliente;
import contas.Conta;
import contas.ContaCorrente;
import errors.SaldoInsuficiente;
import produtos.CDB;
import produtos.Funds;
import produtos.LCA;
import produtos.LCI;

public class exec {
    public static void main(String[] args) throws ParseException {

        CDB cbd = new CDB();
        Funds funds = new Funds();
        LCA lca = new LCA();
        LCI lci = new LCI();
        
        // instancias
        Cliente lucas = new Cliente("Lucas", "Paulista", "69/42/2004");
        Cliente davi = new Cliente("Davi", "Santa Cruz", "42/00/6900");

        ContaCorrente contaLucas = new ContaCorrente(lucas, 420);
        ContaCorrente contaDavi = new ContaCorrente(davi, 69);


        // simulacoes
        contaLucas.depositar(69420);
        contaDavi.depositar(42069);

        try {
            contaDavi.transferir(contaLucas, 420);
        } catch (SaldoInsuficiente e) {
            e.printStackTrace();
        }
        try {
            contaDavi.sacar(42069);
        } catch (SaldoInsuficiente e) {
            e.printStackTrace();
        }

        contaLucas.exibirSaldo();
        contaDavi.exibirSaldo();

        try {
            contaLucas.investimento(420, cbd);
        } catch (SaldoInsuficiente e) {
            e.printStackTrace();
        }
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        try {
            contaLucas.investimento(420, funds);
        } catch (SaldoInsuficiente e) {
            e.printStackTrace();
        }
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        try {
            contaLucas.investimento(420, lca);
        } catch (SaldoInsuficiente e) {
            e.printStackTrace();
        }
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        try {
            contaLucas.investimento(420, lci);
        } catch (SaldoInsuficiente e) {
            e.printStackTrace();
        }
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        contaLucas.exibirSaldo();

        Conta.exibirContador();
    }
}
