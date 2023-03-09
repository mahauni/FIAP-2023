import java.text.ParseException;

import clientes.Cliente;
import contas.Conta;
import contas.ContaCorrente;
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

        contaDavi.transferir(contaLucas, 420);
        contaDavi.sacar(42069);

        contaLucas.exibirSaldo();
        contaDavi.exibirSaldo();

        contaLucas.investimento(420, cbd);
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        contaLucas.investimento(420, funds);
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        contaLucas.investimento(420, lca);
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        contaLucas.investimento(420, lci);
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        contaLucas.exibirSaldo();

        Conta.exibirContador();
    }
}
