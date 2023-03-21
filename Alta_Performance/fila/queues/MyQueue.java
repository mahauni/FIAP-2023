package queues;

public class MyQueue {
    public int ini;
    public int fim;
    public int N;
    public int dados[];

    public void init(int n) {
        ini = 0;
        fim = 0;
        N = n;
        dados = new int[N];
    }

    public void enqueue(int e) {
        if (!isFull()) {
            dados[fim % N] = e;
            fim++;
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int e = dados[ini % N];
            ini++;
            return e;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (ini == fim)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (ini != fim && ini % N == fim % N)
            return true;
        else
            return false;
    }
}