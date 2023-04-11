package aplicacao;

// Integrantes:
// Lucas Raoni Hideki Antunes RM: 92854

import java.util.Scanner;

import entidades.Mensagem;
import fila.FilaMensagens;

public class AtendimentoMensagem {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        FilaMensagens filaReclamacao = new FilaMensagens();
        FilaMensagens filaSugestao = new FilaMensagens();
        FilaMensagens filaResolucao = new FilaMensagens();

        int option;
        int contato;

        do {
            System.out.println("1) Recebimento de Mensagem");
            System.out.println("2) Atendimento de Mensagem");
            System.out.println("3) Recevimento e Encaminhamento de Resolucao");
            System.out.println("0) Encerrar o Programa");
            System.out.println("O que voce deseja fazer: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Voce vai fazer o contato por: 1 - Email 2 - Telefone");
                    contato = sc.nextInt();

                    while (true) {

                        if (contato == 1 || contato == 2) {
                            Mensagem msg = initialize_message(contato); 

                            if (msg.getReason() == 1) {
                                filaReclamacao.enqueue(msg);
                            }
                            if (msg.getReason() == 2) {
                                filaSugestao.enqueue(msg);
                            }

                            break;
                        }

                        System.out.println("Digite uma opcao valida");
                        System.out.println("Voce vai fazer o contato por: 1 - Email 2 - Telefone");
                        contato = sc.nextInt();
                    }
                    break;

                case 2:
                    System.out.println("Qual mensagem voce deseja responder, 1 - Reclamacao 2 - Sugestao");
                    int resp = sc.nextInt();

                    while (true) {

                        if (resp == 1 || resp == 2) {
                            Mensagem msg = null;
                            if (resp == 1) {
                                msg = filaReclamacao.dequeue(); 
                            }
                            if (resp == 2) {
                                msg = filaSugestao.dequeue();
                            }

                            if (msg == null) {
                                System.out.println("Nao tem mais nenhuma mensagem na fila escolhida.");
                                break;
                            }

                            System.out.println(msg);

                            System.out.println("Se a mensagem for sobre uma assunto que possa ser prontamente respondivel digite 1, se precisar ser encaminhado para outro setor, digite 2");

                            int diff = sc.nextInt();
                            while (diff != 1 && diff != 2) {
                                System.out.println("Digite uma comando valido: ");
                                diff = sc.nextInt();
                            }
                            
                            if (diff == 1) {
                                System.out.println("Enviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");
                            }
                            if (diff == 2) {
                                System.out.println("Essa mensagem e necessaria a transferencia para um outro setor. Porfavor espere mais alguns minutos.");
                                filaReclamacao.enqueue(msg);
                            }

                            break;
                        }

                        System.out.println("Digite uma opcao valida");
                        System.out.println("Qual mensagem voce deseja responder, 1 - Reclamacao 2 - Sugestao");
                        contato = sc.nextInt();
                    }
                    break;

                case 3:
                    Mensagem msg = filaResolucao.dequeue();

                    if (msg == null) {
                        System.out.println("Nao tem mensagens na fila de resolucao.");
                        break;
                    }

                    System.out.println(msg);

                    System.out.println("Enviada resposta para cliente: sua solicitação já foi resolvida pelo setor responsável. Obrigado!!!");
                    break;

                case 0:
                    break;
                default:
                    System.out.println("Comando inexistente, digite um comando valido.\n");
                    break;
            }

        } while (option != 0);
    }

    public static Mensagem initialize_message(int contato) {
        sc.nextLine();
        System.out.println("Qual e o seu nome: (Opcional)");
        String name = sc.nextLine();

        String contact = "";
        if (contato == 1) {
            System.out.println("Digite seu email:");
            contact = sc.nextLine();            
        }
        if (contato == 2) {
            System.out.println("Digite seu telefone");
            contact = sc.nextLine();
        }

        System.out.println("Qual e o seu motivo de contato?");
        System.out.println("1) Reclamacao");
        System.out.println("2) Sugestao");
        int reason = sc.nextInt();
        while (reason != 1 && reason != 2) {
            System.out.println("Digite um motivo de contato valido: ");
            reason = sc.nextInt();
        }
        
        sc.nextLine(); // flush
        System.out.println("Qual e a sua mensagem");
        String message = sc.nextLine();
        
        return new Mensagem(name, message, contact, reason);
    }
}
