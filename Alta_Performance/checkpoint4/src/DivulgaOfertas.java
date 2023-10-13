import java.util.List;
import java.util.Scanner;

public class DivulgaOfertas {
    /*
     * NOMES E RM dos alunos que compõem o grupo
     * Lucas Raoni Hideki Antunes RM: 92854
     */
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        Scanner la = new Scanner(System.in);
        /*
         * Cria a uma árvore de busca binária para cada tipo de conta
         * (pessoa física ou jurídica)
         */
        ABBClientes arvorePessoaFisica = new ABBClientes();
        ABBClientes arvorePessoaJuridica = new ABBClientes();
        int opcao, op, op1, numeroConta = 0;
        String nome, cpfCnpj;
        enumTipoConta tipoConta = null, conta = null;
        float saldo;
        ABBClientes arvore = null;

        List<Cliente> clientes = null;

        do {
            System.out.println(" 0 - Encerrar o programa");
            System.out.println(" 1 - Inscrição cliente");
            System.out.println(" 2 - Oferta de novo serviço e/ou aplicação");
            System.out.println(" 3 – Entrar no Submenu ");
            opcao = le.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite nome: ");
                    nome = le.next();

                    do {
                        System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                tipoConta = enumTipoConta.CPF;
                                System.out.print("Digite o seu CPF: ");
                                String cpf = la.nextLine();
                                numeroConta = Integer.parseInt(cpf.replaceAll("[^0-9]", ""));
                                break;
                            case 2:
                                tipoConta = enumTipoConta.CNPJ;
                                System.out.print("Digite o seu CNPJ: ");
                                String cnpj = la.nextLine();
                                numeroConta = Integer.parseInt(cnpj.replaceAll("[^0-9]", ""));
                                break;
                            default:
                                System.out.println("Opção inválida ");
                                op = -1;
                        }
                    } while (op == -1);
                    System.out.print("Informe saldo em aplicações R$: ");
                    saldo = le.nextFloat();

                    Cliente cliente = new Cliente(nome, numeroConta, tipoConta, saldo);

                    if (tipoConta == enumTipoConta.CPF)
                        arvorePessoaFisica.root = arvorePessoaFisica.inserir(arvorePessoaFisica.root, cliente);
                    if (tipoConta == enumTipoConta.CNPJ)
                        arvorePessoaJuridica.root = arvorePessoaJuridica.inserir(arvorePessoaJuridica.root, cliente);
                    /*
                     * Intancia um objeto da classe Cliente e insere na ABB correspondente
                     * a tipo de conta
                     */
                    break;
                case 2:
                    System.out.print("Qual tipo de conta a oferta se destina? ");
                    do {
                        System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                tipoConta = enumTipoConta.CPF;
                                break;
                            case 2:
                                tipoConta = enumTipoConta.CNPJ;
                                break;
                            default:
                                System.out.println("Opção inválida ");
                                op = -1;
                        }
                    } while (op == -1);
                    System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
                    saldo = le.nextFloat();

                    if (tipoConta == enumTipoConta.CPF)
                        clientes = arvorePessoaFisica.listaOfertas(arvorePessoaFisica.root, saldo);
                    if (tipoConta == enumTipoConta.CNPJ)
                        clientes = arvorePessoaJuridica.listaOfertas(arvorePessoaJuridica.root, saldo);

                    System.out.println(clientes);

                    for (Cliente c : clientes) {
                        System.out.println(c);
                        System.out.println("Você deseja aceitar a oferta?");
                        do {
                            System.out.print("Digite 1- SIM 2- NÃO: ");
                            op = le.nextInt();
                            switch (op) {
                                case 1:
                                    System.out.println("A oferta foi aceita pelo cliente!");
                                    // isso nao vai ser um problema porque pode ter 2 contas com o mesmo valor
                                    // de saldo?
                                    if (c.getTipoConta() == enumTipoConta.CPF)
                                        arvorePessoaFisica.root = arvorePessoaFisica.removeValor(arvorePessoaFisica.root, c.getSaldo());
                                    if (c.getTipoConta() == enumTipoConta.CNPJ)
                                        arvorePessoaJuridica.root = arvorePessoaJuridica.removeValor(arvorePessoaJuridica.root, c.getSaldo());
                                    break;
                                case 2:
                                    System.out.println("O cliente recusou a oferta!");
                                    break;
                                default:
                                    System.out.println("Opção inválida ");
                                    op = -1;
                            }
                        } while (op == -1);
                    }

                    break;
                case 3:
                    do {
                        System.out.println("Qual é a sua conta? (CNPJ OU CPF)");
                        op1 = le.nextInt();
                        switch (op1) {
                            case 1:
                                conta = enumTipoConta.CPF;
                                arvore = arvorePessoaFisica;

                                break;
                            case 2:
                                conta = enumTipoConta.CNPJ;
                                arvore = arvorePessoaJuridica;
                                break;
                            default:
                                System.out.println("Inválido");
                                op1 = -1;
                                break;
                        }
                    } while (op1 != -1);
                    do {
                        System.out.println(" 0 - Voltar para o menu principal");
                        System.out.println(" 1 - Consultar cliente");
                        System.out.println(" 2 - Atualizar saldo do cliente");
                        System.out.println(" 3 – Quantidade de clientes");
                        System.out.println(" 4 – Quantidade de clientes acima de:");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                System.out.println("Digite o numero do " + conta.toString() + ":");
                                String strNum = la.nextLine();
                                int num = Integer.parseInt(strNum.replaceAll("[^0-9]", ""));
                                System.out.println(arvore.findClienteByNum(arvore.root, num));
                                break;
                            case 2:
                                System.out.println("Digite o " + conta.toString() + ":");
                                String strNumCon = la.nextLine();
                                int numCon = Integer.parseInt(strNumCon.replaceAll("[^0-9]", ""));
                                System.out.println("Digite o novo saldo:");
                                saldo = le.nextFloat();
                                arvore.updateCliente(arvore.root, numCon, saldo);
                                break;
                            case 3:
                                System.out.println(arvore.conta(arvore.root, 0));
                                break;
                            case 4:
                                System.out.println("Qual é o saldo?");
                                saldo = le.nextFloat();
                                System.out.println(arvore.listaOfertas(arvore.root, 0));
                                break;
                            default:
                                System.out.println("Opção inválida ");
                        }
                    } while (op != 0);
                    break;
            }
        } while (opcao != 0);
        System.out.println("Clientes que não aceitaram ou não estavam adequados para a oferta");
                /*
                 * Esvazia as ABBs apresentando todos os clientes que aguardam nova portunidade
                 */
                arvorePessoaFisica.mostra(arvorePessoaFisica.root);
                arvorePessoaJuridica.mostra(arvorePessoaJuridica.root);
                le.close();
                la.close();
    }
}