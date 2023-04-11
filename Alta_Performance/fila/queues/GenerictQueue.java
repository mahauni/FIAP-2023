package queues;

public class GenerictQueue<T> {
    private int ini;
    private int fim;
    private int N;
    private T dados[];

    public void init(int n) {
        ini = 0;
        fim = 0;
        N = n;
        dados = new T[N];
    }

    public void enqueue(T e) {
        if (!isFull()) {
            dados[fim % N] = e;
            fim++;
        } else {
            System.out.println("Queue full");
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            T e = dados[ini % N];
            ini++;
            return e;
        }
        return null;
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

    public T first() {
        if (isEmpty()) {
            return null;
        }
        return dados[ini % N];
    }

    public int getIni() {
        return this.ini;
    }
    public int getFim() {
        return this.fim;
    }
}
