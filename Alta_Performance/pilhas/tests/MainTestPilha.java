package tests;

import pilhas.PilhaInt;

public class MainTestPilha {
    public static void main(String[] args) {
        PilhaInt pilha = new PilhaInt();
        pilha.init();

        pilha.push(123);
        pilha.push(53);

        if (!pilha.isEmpty()) 
            System.out.println("Valor retirado da pilha: " + pilha.pop());
        else
            System.out.println("Pilha vazia");

            if (!pilha.isEmpty()) 
            System.out.println("Valor do dado do topo da pilha: " + pilha.top());
        else
            System.out.println("Pilha vazia");

        if (!pilha.isEmpty()) 
            System.out.println("Valor retirado da pilha: " + pilha.pop());
        else
            System.out.println("Pilha vazia");

        pilha.push(69);
        pilha.push(420);
        pilha.push(69420);
        pilha.push(42069);
        pilha.push(1773);

        System.out.println("Esvaziando lista....");
        pilha.esvazia();
    }
}
