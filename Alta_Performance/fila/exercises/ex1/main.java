package exercises.ex1;

import java.util.Scanner;

import queues.MyQueue;

public class main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.init(20);
        Scanner sc = new Scanner(System.in);
        
        int opcao, rm;

        loop: while (true) {
            System.out.println("1) Insert aluno in queue (Identify by RM)");
            System.out.println("2) Remove aluno para atendimento");
            System.out.println("0) Stop the program");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o RM do aluno: ");
                    rm = sc.nextInt();
                    q.enqueue(rm);
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
