public class test {
    public static void main(String[] args) {
        ABBClientes arvore = new ABBClientes();

        for (int i = 1; i < 10; i++) {
            Cliente cliente = new Cliente("Lucas", i, enumTipoConta.CPF, 1200 * i);
            arvore.root = arvore.inserir(arvore.root, cliente);
        }

        arvore.mostra(arvore.root);

        System.out.println(arvore.listaOfertas(arvore.root, 5000));
    }
}
