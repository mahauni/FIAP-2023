import clientes.Cliente;
import contas.ContaCorrente;

public class exec {
    public static void main(String[] args) {
        
        // instancias
        Cliente lucas = new Cliente("Lucas", "Paulista", "69/42/0");
        Cliente davi = new Cliente("Davi", "Santa Cruz", "42/00/69");

        ContaCorrente contaLucas = new ContaCorrente(lucas, 420);
        ContaCorrente contaDavi = new ContaCorrente(davi, 69);


        // simulacoes
        contaLucas.depositar(69420);
        contaDavi.depositar(42069);

        contaDavi.transferir(contaLucas, 420);
        contaDavi.sacar(42069);

        contaLucas.exibirSaldo();
        contaDavi.exibirSaldo();

        contaLucas.investir(420, 2);
        System.out.println("Saldo investimento: " + contaLucas.getSaldoInvestimento());
        contaLucas.exibirSaldo();
    }
}
