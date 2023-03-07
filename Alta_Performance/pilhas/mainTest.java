import pilhas.PilhaInt;

public class mainTest {
    public static void main(String[] args) {
        PilhaInt pilha = new PilhaInt();
        pilha.init();

        pilha.push(123);
        pilha.push(53);

        System.out.println(pilha.pop());
        System.out.println(pilha.pop());
    }
}
