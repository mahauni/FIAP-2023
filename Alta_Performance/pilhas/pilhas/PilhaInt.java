package pilhas;

public class PilhaInt {
    public final int N = 10;

    int dados[] = new int[N];
    int top;

    public void init() {
        top = 0;
    }

    public void push(int elem) {
        if (isFull())
            System.out.println("Stack overflow");
        else {
            dados[top] = elem;
            top += 1;
        }
    }

    public int pop() {
        top -= 1;
        return dados[top];
    }

    public boolean isEmpty() {
        if (top == 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (top == N)
            return true;
        else
            return false;
    }

    public int top() {
        return dados[top - 1];
    }

    public void clear() {
        top = 0;
    }

    public void esvazia() {
        while (!isEmpty())
            System.out.print(" " + pop());
        System.out.println();
    }
}
