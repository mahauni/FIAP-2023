package exercises;

import java.util.Scanner;

import queues.*;

public class ex5 {
    public static void main(String[] args) {
        QueueString q = new QueueString();
        q.init(20);
        Scanner sc = new Scanner(System.in);
        
        int opcao;
        String nome;

        loop: while (true) {
            System.out.println("1) Insert aluno in queue (Identify by RM)");
            System.out.println("2) Remove aluno para atendimento");
            System.out.println("0) Stop the program");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.print("Digite o RM do aluno: ");
                    nome = sc.nextLine();
                    q.enqueue(nome);
                    break;
                case 2:
                    System.out.println("Aluno retirado: " + q.dequeue());
                    break;
                case 0:
                    break loop;
                default:
                    System.out.println("Opçao invalida");
                    break;
            }
        }

        sc.close();
    }
}
