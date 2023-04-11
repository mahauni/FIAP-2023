package queues;

// Uses a count to make sure the array buffer is not full 
// Need to verify if the queue if is empty in the main when dequeue some value
// Because we dont verify here.
public class ProfQueue {
    private int ini;
    private int fim;
    private int cont;
    private int N;
    private int dados[];

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

    public int first() {
        return dados[ini];
    }

    public int getIni() {
        return this.ini;
    }
    public int getFim() {
        return this.fim;
    }
}
