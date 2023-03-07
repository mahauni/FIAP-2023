package pilhas;

public class PilhaInt {
    public final int N = 6;
    int dados[] = new int[N];
    int top;

    public void init() {
        top = 0;
    }

    public void push(int elem) {
        dados[top] = elem;
        top += 1;
    }

    public int pop() {
        top -= 1;
        return dados[top];
    }
}
