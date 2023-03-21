package queues;

public class ProfQueue {
    public int ini;
    public int fim;
    public int cont;
    public int N;
    public int dados[];

    public void init(int n) {
        ini = 0;
        fim = 0;
        cont = 0;
        N = n;
        dados = new int[N];
    }

    public void enqueue(int e) {
        if (isFull()) {
            System.out.println("Fila cheia");
        } else {
            dados[fim] = e;
            fim = (fim + 1) % N;
            cont++;
        }
    }

    public int dequeue() {
        int e = dados[ini];
        ini = (ini + 1) % N;
        cont--;
        return e;
    }

    public boolean isEmpty() {
        if (cont == 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (cont == N)
            return true;
        else
            return false;
    }
}
