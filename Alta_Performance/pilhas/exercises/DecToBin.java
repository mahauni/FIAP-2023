package exercises;

import pilhas.PilhaInt;

public class DecToBin {
    public static void main(String[] args) {
        String bin = "";
        int numero_decimal = 69;
        PilhaInt pilha = new PilhaInt();
        pilha.init();

        while (numero_decimal != 0) {
            pilha.push(numero_decimal % 2);
            numero_decimal /= 2;
        }

        while (!pilha.isEmpty()) {
            int bit = pilha.pop();
            bin += bit;
        }

        System.out.println("O binario sera: " + bin);
    }
}
